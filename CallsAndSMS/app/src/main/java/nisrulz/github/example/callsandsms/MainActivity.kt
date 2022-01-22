package nisrulz.github.example.callsandsms

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import android.telephony.TelephonyManager
import android.os.Bundle
import nisrulz.github.example.callsandsms.R
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import android.view.View
import android.text.TextUtils
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import android.telephony.PhoneStateListener
import android.telephony.SmsManager

class MainActivity : AppCompatActivity() {
    private var etPhoneNo: EditText? = null
    private var btnDial: Button? = null
    private var btnCall: Button? = null
    private var telephonyManager: TelephonyManager? = null
    private var etMessage: EditText? = null
    private var btnSendMessage: Button? = null
    private var btnSendMessageDirectly: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkIfPermissionGranted()
        initView()
        telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
    }

    fun isPermissionGranted(permission: String?): Boolean {
        return (ContextCompat.checkSelfPermission(this@MainActivity, permission!!)
                == PackageManager.PERMISSION_GRANTED)
    }

    fun checkIfPermissionGranted() {
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
    }

    private fun initView() {
        etPhoneNo = findViewById<View>(R.id.et_phone_no) as EditText
        btnDial = findViewById<View>(R.id.btn_dial) as Button
        btnCall = findViewById<View>(R.id.btn_call) as Button
        btnDial!!.setOnClickListener {
            val phoneNo = etPhoneNo!!.text.toString()
            if (!TextUtils.isEmpty(phoneNo)) {
                val dial = "tel:$phoneNo"
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(dial)))
            } else {
                Toast.makeText(this@MainActivity, "Enter a phone number", Toast.LENGTH_SHORT).show()
            }
        }
        btnCall!!.setOnClickListener {
            val phoneNo = etPhoneNo!!.text.toString()
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
                Toast.makeText(this@MainActivity, "Enter a phone number", Toast.LENGTH_SHORT).show()
            }
        }
        etMessage = findViewById<View>(R.id.et_message) as EditText
        btnSendMessage = findViewById<View>(R.id.btn_send_message) as Button
        btnSendMessage!!.setOnClickListener {
            val message = etMessage!!.text.toString()
            val phoneNo = etPhoneNo!!.text.toString()
            if (!TextUtils.isEmpty(message) && !TextUtils.isEmpty(phoneNo)) {
                val smsIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNo"))
                smsIntent.putExtra("sms_body", message)
                startActivity(smsIntent)
            }
        }
        btnSendMessageDirectly = findViewById<View>(R.id.btn_send_message_directly) as Button
        btnSendMessageDirectly!!.setOnClickListener {
            val message = etMessage!!.text.toString()
            val phoneNo = etPhoneNo!!.text.toString()
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

    override fun onResume() {
        super.onResume()
        telephonyManager!!.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
    }

    override fun onStop() {
        super.onStop()
        telephonyManager!!.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE)
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