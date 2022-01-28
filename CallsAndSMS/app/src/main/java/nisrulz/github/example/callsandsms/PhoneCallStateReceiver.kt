package nisrulz.github.example.callsandsms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.widget.Toast

// Listen for call states when in background
class PhoneCallStateReceiver : BroadcastReceiver() {
    private var telephonyManager: TelephonyManager? = null

    override fun onReceive(context: Context, intent: Intent) {
        telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val phoneStateListener: PhoneStateListener = object : PhoneStateListener() {
            override fun onCallStateChanged(state: Int, incomingNumber: String) {
                super.onCallStateChanged(state, incomingNumber)
                when (state) {
                    TelephonyManager.CALL_STATE_IDLE -> Toast.makeText(
                        context,
                        "CALL_STATE_IDLE : Detected in BG",
                        Toast.LENGTH_SHORT
                    ).show()
                    TelephonyManager.CALL_STATE_RINGING -> Toast.makeText(
                        context,
                        "CALL_STATE_RINGING : Detected in BG",
                        Toast.LENGTH_SHORT
                    ).show()
                    TelephonyManager.CALL_STATE_OFFHOOK -> Toast.makeText(
                        context,
                        "CALL_STATE_OFFHOOK : Detected in BG",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        if (!isListening) {
            telephonyManager?.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
            isListening = true
        }
    }

    companion object {
        var isListening = false
    }
}