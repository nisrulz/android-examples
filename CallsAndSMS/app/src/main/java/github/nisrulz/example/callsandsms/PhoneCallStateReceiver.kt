package github.nisrulz.example.callsandsms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.PhoneStateListener
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getMainExecutor

// Listen for call states
class PhoneCallStateReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        /**
         * This broadcast receiver declares an intent-filter for a protected broadcast action string,
         * which can only be sent by the system, not third-party applications.
         * If we don't check the action we are getting in this onReceive function, then we are
         * potentially making it possible for another actor to send a spoofed intent with no
         * action string or a different action string and cause undesired behavior.
         */
        if (intent.action == "android.intent.action.PHONE_STATE"
            || intent.action == "android.intent.action.NEW_OUTGOING_CALL"
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                telephonyManager.registerTelephonyCallback(
                    getMainExecutor(context),
                    CustomTelephonyCallback()
                )
            } else {
                telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.S)
    inner class CustomTelephonyCallback : TelephonyCallback(),
        TelephonyCallback.CallStateListener {
        override fun onCallStateChanged(state: Int) {
            baseOnCallStateChanged(state)
        }
    }

    private val phoneStateListener = object : PhoneStateListener() {
        override fun onCallStateChanged(state: Int, phoneNumber: String?) {
            super.onCallStateChanged(state, phoneNumber)
            baseOnCallStateChanged(state)
        }
    }

    private fun baseOnCallStateChanged(state: Int) {
        when (state) {
            TelephonyManager.CALL_STATE_IDLE ->
                Log.d("PhoneCallStateReceiver", "CALL_STATE_IDLE : Detected in background")
            TelephonyManager.CALL_STATE_RINGING ->
                Log.d("PhoneCallStateReceiver", "CALL_STATE_RINGING : Detected in background")
            TelephonyManager.CALL_STATE_OFFHOOK ->
                Log.d("PhoneCallStateReceiver", "CALL_STATE_OFFHOOK : Detected in background")
        }
    }
}