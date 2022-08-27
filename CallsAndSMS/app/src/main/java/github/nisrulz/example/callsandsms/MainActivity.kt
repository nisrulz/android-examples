package github.nisrulz.example.callsandsms

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresPermission
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import github.nisrulz.example.callsandsms.databinding.ActivityMainBinding

private const val TELEPHONE_PROTOCOL = "tel"
private const val SMS_PROTOCOL = "smsto"

class MainActivity : AppCompatActivity() {

    companion object {
        private val REQUIRED_PERMISSIONS = arrayOf(
            Manifest.permission.CALL_PHONE,
            Manifest.permission.SEND_SMS,
            Manifest.permission.RECEIVE_SMS,
            Manifest.permission.READ_PHONE_STATE
        )
    }

    private lateinit var phoneCallStateReceiver: PhoneCallStateReceiver
    private lateinit var smsReceiver: SMSReceiver

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            checkForPermissions()
            setOnClickListeners()
        }
    }

    override fun onResume() {
        super.onResume()
        val phoneStateFilter = IntentFilter("android.intent.action.PHONE_STATE")
        val smsReceiverFilter = IntentFilter("android.provider.Telephony.SMS_RECEIVED")
        phoneCallStateReceiver = PhoneCallStateReceiver()
        smsReceiver = SMSReceiver()
        registerReceiver(phoneCallStateReceiver, phoneStateFilter)
        registerReceiver(smsReceiver, smsReceiverFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(phoneCallStateReceiver)
        unregisterReceiver(smsReceiver)
    }

    private fun setOnClickListeners() {
        with(binding) {
            btnDial.setOnClickListener {
                val phoneNo = etPhoneNo.text.toString()
                if (!TextUtils.isEmpty(phoneNo)) {
                    val dialUri = createUriForProtocol(TELEPHONE_PROTOCOL, phoneNo)
                    startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(dialUri)))
                } else {
                    showToast("Enter a phone number")
                }
            }
            btnCall.setOnClickListener {
                val phoneNo = etPhoneNo.text.toString()
                makeCall(phoneNo)
            }
            btnSendMessage.setOnClickListener {
                val message = etMessage.text.toString()
                val phoneNo = etPhoneNo.text.toString()
                if (!TextUtils.isEmpty(message) && !TextUtils.isEmpty(phoneNo)) {
                    val smsIntent = Intent(
                        Intent.ACTION_SENDTO, Uri.parse(
                            createUriForProtocol(
                                SMS_PROTOCOL, phoneNo
                            )
                        )
                    )
                    smsIntent.putExtra("sms_body", message)
                    startActivity(smsIntent)
                }
            }
        }
    }

    private fun makeCall(phoneNo: String) {
        if (!TextUtils.isEmpty(phoneNo)) {
            val dialUri = createUriForProtocol(TELEPHONE_PROTOCOL, phoneNo)
            // Requires Permission to be declared in manifest
            // <uses-permission android:name="android.permission.CALL_PHONE"/>
            // Then check and request for permission during runtime
            @RequiresPermission(Manifest.permission.CALL_PHONE)
            if (isPermissionGranted(Manifest.permission.CALL_PHONE)) {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse(dialUri))
                startActivity(intent)
            } else {
                showToast("Permission not granted yet!")
            }
        } else {
            showToast("Enter a phone number")
        }
    }

    private fun createUriForProtocol(protocol: String, data: String) = "$protocol:$data"

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { }

    private fun checkForPermissions() {
        if (!allPermissionsGranted()) {
            askForPermission()
        }
    }

    /**
     * Checks if all the permissions mentioned in [REQUIRED_PERMISSIONS]
     * are granted or not.
     */
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all { permission ->
        ContextCompat.checkSelfPermission(
            this, permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Checks if the [permission] are granted or not.
     */
    private fun isPermissionGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            this, permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Request for permissions mentioned in [REQUIRED_PERMISSIONS].
     * This will invoke the [ActivityResultContracts]
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