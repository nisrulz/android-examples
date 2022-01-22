package nisrulz.github.example.callsandsms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Build
import android.telephony.SmsMessage
import android.widget.Toast

class SMSReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val bundle = intent.extras
        if (bundle != null) {
            val pdus = bundle["pdus"] as Array<Any>?
            val format = bundle.getString("format")
            val messages = arrayOfNulls<SmsMessage>(
                pdus!!.size
            )
            for (i in pdus.indices) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    messages[i] = SmsMessage.createFromPdu(pdus[i] as ByteArray, format)
                } else {
                    messages[i] = SmsMessage.createFromPdu(pdus[i] as ByteArray)
                }
                val senderPhoneNo = messages[i].getDisplayOriginatingAddress()
                Toast.makeText(
                    context,
                    "Message " + messages[0].getMessageBody() + ", from " + senderPhoneNo,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}