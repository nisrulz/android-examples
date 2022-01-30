package github.nisrulz.example.cameraX

import android.Manifest
import android.content.ContentValues
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.common.util.concurrent.ListenableFuture
import github.nisrulz.example.cameraX.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

private const val IMMERSIVE_FLAG_TIMEOUT = 500L

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageCapture: ImageCapture

    companion object {
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"

        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }

        checkForPermissions()
        binding.imageCaptureButton.setOnClickListener { captureImage() }
    }

    /**
     * Once the view(container) sets on the screen completely, we set fullscreen flag.
     */
    override fun onResume() {
        super.onResume()
        binding.container.postDelayed({
            hideSystemUI()
        }, IMMERSIVE_FLAG_TIMEOUT)
    }

    /**
     * Capture and save the still image.
     */
    private fun captureImage() {
        imageCapture.let {
            val filename = createFilename()
            val contentValues = createContentValuesForImageFile(filename)
            it.takePicture(
                getOutputOptions(contentValues),
                ContextCompat.getMainExecutor(this),
                onImageSavedCallback
            )
        }
    }

    /**
     * Configure image saving location and it's meta data.
     */
    private fun getOutputOptions(contentValues: ContentValues) = ImageCapture.OutputFileOptions
        .Builder(
            contentResolver,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            contentValues
        ).build()

    /**
     * Create time stamped filename.
     */
    private fun createFilename() = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
        .format(System.currentTimeMillis())

    /**
     * Create values to add in the created image file.
     */
    private fun createContentValuesForImageFile(filename: String) = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
            put(
                MediaStore.Images.Media.RELATIVE_PATH,
                "Pictures/Android-Examples-CameraX-Image"
            )
        }
    }

    /**
     * Callback to listen after image gets saved.
     */
    private val onImageSavedCallback by lazy {
        object : ImageCapture.OnImageSavedCallback {
            override fun onError(e: ImageCaptureException) {
                Log.e(MainActivity::class.simpleName, "Photo capture failed: ${e.message}", e)
            }

            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                val msg = "Photo capture succeeded: ${output.savedUri}"
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Configure camera by providing use cases and binding to lifecycle.
     */
    private fun startCamera() {
        val cameraProviderListenableFuture: ListenableFuture<ProcessCameraProvider> =
            ProcessCameraProvider.getInstance(this)

        // addListener requires 2 parameter
        //  - Runnable
        //  - Executor
        cameraProviderListenableFuture.addListener({
            val cameraSelectorUseCase = getCameraSelectorUseCase()
            val previewUseCase = getPreviewUseCase()
            imageCapture = getImageCapture()
            val processCameraProvider = getProcessCameraProvider(cameraProviderListenableFuture)
            try {
                // Unbind all use cases before rebinding
                processCameraProvider.unbindAll()

                // Bind all the use cases to camera
                processCameraProvider.bindToLifecycle(
                    this@MainActivity,
                    cameraSelectorUseCase,
                    previewUseCase,
                    imageCapture
                )
            } catch (e: Exception) {
                Log.e(MainActivity::class.simpleName, "Use case binding failed", e)
            }
        }, ContextCompat.getMainExecutor(this))
    }

    /**
     * Select which camera to use.
     */
    private fun getCameraSelectorUseCase() = CameraSelector.DEFAULT_BACK_CAMERA

    /**
     * Create Preview use case to display camera feeds.
     */
    private fun getPreviewUseCase() = Preview.Builder()
        .build()
        .also { preview ->
            preview.setSurfaceProvider(binding.preview.surfaceProvider)
        }

    /**
     * Create a use case for taking pictures.
     */
    private fun getImageCapture() = ImageCapture.Builder().build()

    /**
     * CameraX is lifecycle-aware and [ProcessCameraProvider] helps
     * in binding the lifecycle of the camera with our lifecycle owner.
     */
    private fun getProcessCameraProvider(
        cameraProviderListenableFuture: ListenableFuture<ProcessCameraProvider>
    ) = cameraProviderListenableFuture.get()

    /**
     * Checks if all the permissions mentioned in [REQUIRED_PERMISSIONS]
     * are granted or not.
     */
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all { permission ->
        ContextCompat.checkSelfPermission(
            this, permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, binding.container).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    private fun checkForPermissions() {
        when {
            allPermissionsGranted() -> {
                startCamera()
            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                REQUIRED_PERMISSIONS[0]
            ) -> {
                showToast(
                    "Camera access is required to display camera preview"
                )
                askForPermission()
            }
            else -> {
                askForPermission()
            }
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            permissions.entries.forEach { map ->
                if (map.key == REQUIRED_PERMISSIONS[0] && map.value) {
                    startCamera()
                } else if (map.key == REQUIRED_PERMISSIONS[0] && !map.value) {
                    showToast(
                        "Camera access is required to display camera preview",
                    )
                } else {
                    showToast(
                        "Permissions are not granted by the user.",
                    )
                    finish()
                }
            }
        }

    /**
     * Request for permissions mentioned in [REQUIRED_PERMISSIONS].
     * This will invoke the [ActivityResultContract]
     */
    private fun askForPermission() {
        requestPermissionLauncher.launch(
            REQUIRED_PERMISSIONS
        )
    }

    /**
     * Display the [Toast] UI.
     */
    private fun showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(
            this,
            message,
            duration
        ).show()
    }
}
