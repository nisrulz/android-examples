package nisrulz.github.example.callsandsms

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.PhoneStateListener
import android.telephony.SmsManager
import android.telephony.TelephonyManager
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import nisrulz.github.example.callsandsms.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val telephonyManager: TelephonyManager by lazy {
        getSystemService(TELEPHONY_SERVICE) as TelephonyManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            setContentView(root)
            checkIfPermissionGranted()
            initView(this)
        }
    }

    private fun isPermissionGranted(permission: String): Boolean {
        return (ContextCompat.checkSelfPermission(this@MainActivity, permission)
                == PackageManager.PERMISSION_GRANTED)
    }

    private fun checkIfPermissionGranted() {
        if (isPermissionGranted(Manifest.permission.CALL_PHONE)
            || isPermissionGranted(Manifest.permission.SEND_SMS)
            || isPermissionGranted(Manifest.permission.RECEIVE_SMS)
            || isPermissionGranted(Manifest.permission.READ_PHONE_STATE)
            || isPermissionGranted(Manifest.permission.PROCESS_OUTGOING_CALLS)
        ) {

            // Request runtime permission
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    Manifest.permission.CALL_PHONE, Manifest.permission.SEND_SMS,
                    Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.PROCESS_OUTGOING_CALLS
                ), 100
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun initView(binding: ActivityMainBinding) {
        binding.apply {
            btnDial.setOnClickListener {
                val phoneNo = etPhoneNo.text.toString()
                if (!TextUtils.isEmpty(phoneNo)) {
                    val dial = "tel:$phoneNo"
                    startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(dial)))
                } else {
                    Toast.makeText(this@MainActivity, "Enter a phone number", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            btnCall.setOnClickListener {
                val phoneNo = etPhoneNo.text.toString()
                if (!TextUtils.isEmpty(phoneNo)) {
                    val dial = "tel:$phoneNo"

                    // Requires Permission to be declared in manifest
                    // <uses-permission android:name="android.permission.CALL_PHONE"/>
                    // Then check and request for permission during runtime
                    if (isPermissionGranted(Manifest.permission.CALL_PHONE)) {
                        startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "Permission not granted yet!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Enter a phone number", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            btnSendMessage.setOnClickListener {
                val message = etMessage.text.toString()
                val phoneNo = etPhoneNo.text.toString()
                if (!TextUtils.isEmpty(message) && !TextUtils.isEmpty(phoneNo)) {
                    val smsIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNo"))
                    smsIntent.putExtra("sms_body", message)
                    startActivity(smsIntent)
                }
            }
            btnSendMessageDirectly.setOnClickListener {
                val message = etMessage.text.toString()
                val phoneNo = etPhoneNo.text.toString()
                if (!TextUtils.isEmpty(message) && !TextUtils.isEmpty(phoneNo)) {
                    // Requires Permission to be declared in manifest
                    // <uses-permission android:name="android.permission.SEND_SMS"/>
                    // Then check and request for permission during runtime
                    if (isPermissionGranted(Manifest.permission.SEND_SMS)) {
                        val smsManager = SmsManager.getDefault()
                        smsManager.sendTextMessage(phoneNo, null, message, null, null)
                    } else {
                        Toast.makeText(this@MainActivity, "Permission denied", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
    }

    override fun onStop() {
        super.onStop()
        telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE)
    }

    // This listener only works when the app is in foreground
    var phoneStateListener: PhoneStateListener = object : PhoneStateListener() {
        override fun onCallStateChanged(state: Int, incomingNumber: String) {
            super.onCallStateChanged(state, incomingNumber)
            when (state) {
                TelephonyManager.CALL_STATE_IDLE -> Toast.makeText(
                    this@MainActivity,
                    "CALL_STATE_IDLE : Detected in FG",
                    Toast.LENGTH_SHORT
                )
                    .show()
                TelephonyManager.CALL_STATE_RINGING -> Toast.makeText(
                    this@MainActivity, "CALL_STATE_RINGING : Detected in FG",
                    Toast.LENGTH_SHORT
                ).show()
                TelephonyManager.CALL_STATE_OFFHOOK -> Toast.makeText(
                    this@MainActivity, "CALL_STATE_OFFHOOK : Detected in FG",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}