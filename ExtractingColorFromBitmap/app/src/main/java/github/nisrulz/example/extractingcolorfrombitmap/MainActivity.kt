package github.nisrulz.example.extractingcolorfrombitmap

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import androidx.palette.graphics.Palette.PaletteAsyncListener
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import com.squareup.picasso.Picasso.LoadedFrom
import com.squareup.picasso.Target
import github.nisrulz.example.extractingcolorfrombitmap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val RANDOM_IMAGE_URL = "https://unsplash.it/400/?random"
    private val imageDimension by lazy { resources.getDimension(R.dimen.image_size).toInt() }

    private val progressDialog by lazy {
        AlertDialog.Builder(this).run {
            setCancelable(true)
            setView(R.layout.layout_loading_dialog)
            create()
        }
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            setupUi(this)
        }
    }

    private fun setupUi(binding: ActivityMainBinding) {
        with(binding) {
            btnReload.setOnClickListener { loadRandomImage() }
            loadRandomImage()
        }
    }

    private fun handleBitmapLoaded(binding: ActivityMainBinding, bitmap: Bitmap) {
        with(binding) {
            mainImage.setImageBitmap(bitmap)
            Palette.from(bitmap).generate(PaletteAsyncListener { palette ->
                val darkMutedSwatch = palette?.darkMutedSwatch
                if (darkMutedSwatch == null) {
                    makeToast("Null Swatch!")
                    progressDialog.dismiss()
                    return@PaletteAsyncListener
                }
                mainBackground.setBackgroundColor(darkMutedSwatch.rgb)
                mainTitleText.setTextColor(darkMutedSwatch.titleTextColor)
                mainBodyText.setTextColor(darkMutedSwatch.bodyTextColor)
                progressDialog.dismiss()
            })
        }
    }

    private fun makeToast(str: String) = Toast
        .makeText(this, str, Toast.LENGTH_SHORT)
        .show()

    private fun loadRandomImage() {
        Picasso.get().invalidate(RANDOM_IMAGE_URL)

        Picasso.get()
            .load(RANDOM_IMAGE_URL)
            .memoryPolicy(MemoryPolicy.NO_STORE)
            .networkPolicy(NetworkPolicy.NO_CACHE)
            .resize(imageDimension, imageDimension)
            .error(R.drawable.ic_cloud_white_24dp)
            .placeholder(R.drawable.ic_cloud_white_24dp)
            .centerCrop()
            .into(object : Target {
                override fun onBitmapLoaded(bitmap: Bitmap, from: LoadedFrom) {
                    handleBitmapLoaded(binding, bitmap)
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                    progressDialog.dismiss()
                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable) {
                    progressDialog.show()
                }
            })
    }
}