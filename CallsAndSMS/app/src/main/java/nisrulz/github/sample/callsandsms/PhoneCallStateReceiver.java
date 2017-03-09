package nisrulz.github.sample.callsandsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

// Listen for call states when in background
public class PhoneCallStateReceiver extends BroadcastReceiver {
  private TelephonyManager telephonyManager;
  public static boolean isListening = false;

  @Override
  public void onReceive(final Context context, Intent intent) {

    telephonyManager = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);

    PhoneStateListener phoneStateListener = new PhoneStateListener() {
      @Override
      public void onCallStateChanged(int state, String incomingNumber) {
        super.onCallStateChanged(state, incomingNumber);

        switch (state) {
          case TelephonyManager.CALL_STATE_IDLE:
            Toast.makeText(context, "CALL_STATE_IDLE : Detected in BG", Toast.LENGTH_SHORT).show();
            break;
          case TelephonyManager.CALL_STATE_RINGING:
            Toast.makeText(context, "CALL_STATE_RINGING : Detected in BG", Toast.LENGTH_SHORT).show();
            break;
          case TelephonyManager.CALL_STATE_OFFHOOK:
            Toast.makeText(context, "CALL_STATE_OFFHOOK : Detected in BG", Toast.LENGTH_SHORT).show();
            break;
        }
      }
    };

    if (!isListening) {
      telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
      isListening = true;
    }
  }
}