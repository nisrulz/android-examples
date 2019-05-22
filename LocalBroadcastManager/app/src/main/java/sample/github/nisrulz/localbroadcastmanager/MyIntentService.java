package sample.github.nisrulz.localbroadcastmanager;

import android.app.IntentService;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.util.Log;

public class MyIntentService extends IntentService {
  public MyIntentService() {
    super("MyIntentService");
  }

  @Override protected void onHandleIntent(Intent intent) {
    if (intent != null) {
      sendMessage();
    }
  }

  // Send an Intent with an action named "custom-event-name". The Intent
  // sent should
  // be received by the ReceiverActivity.
  private void sendMessage() {
    Log.d("sender", "Broadcasting message");
    Intent intent = new Intent("custom-event-name");
    // You can also include some extra data.
    intent.putExtra("message", "This is my message!");
    LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
  }
}
