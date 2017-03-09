package nisrulz.github.sample.callsandsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    Bundle bundle = intent.getExtras();
    if (bundle != null) {
      Object[] pdus = (Object[]) bundle.get("pdus");
      String format = bundle.getString("format");

      final SmsMessage[] messages = new SmsMessage[pdus.length];
      for (int i = 0; i < pdus.length; i++) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
          messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
        }
        else {
          messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
        }
        String senderPhoneNo = messages[i].getDisplayOriginatingAddress();
        Toast.makeText(context,
            "Message " + messages[0].getMessageBody() + ", from " + senderPhoneNo,
            Toast.LENGTH_SHORT).show();
      }
    }
  }
}