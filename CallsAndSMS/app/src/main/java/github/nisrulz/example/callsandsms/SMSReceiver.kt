package github.nisrulz.example.callsandsms

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
                for (index in indices) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        messages[index] = SmsMessage.createFromPdu(pdus[index] as ByteArray, format)
                    } else {
                        messages[index] = SmsMessage.createFromPdu(pdus[index] as ByteArray)
                    }
                    val senderPhoneNo = messages[index]?.displayOriginatingAddress
                    Log.d(
                        "SMSReceiver",
                        "Message " + messages[0]?.messageBody + ", from " + senderPhoneNo,
                    )
                }
            }
        }
    }
}