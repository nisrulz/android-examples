package nisrulz.github.example.callsandsms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage
import android.util.Log

class SMSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        intent.extras?.let { bundle ->
            val pdus = bundle["pdus"] as Array<*>?
            val format = bundle.getString("format")

            pdus?.apply {
                val messages = arrayOfNulls<SmsMessage>(size)
                for (item in indices) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        messages[item] = SmsMessage.createFromPdu(pdus[item] as ByteArray, format)
                    } else {
                        messages[item] = SmsMessage.createFromPdu(pdus[item] as ByteArray)
                    }
                    val senderPhoneNo = messages[item]?.displayOriginatingAddress
                    Log.d(
                        "SMSReceiver",
                        "Message " + messages[0]?.messageBody + ", from " + senderPhoneNo,
                    )
                }
            }
        }
    }
}