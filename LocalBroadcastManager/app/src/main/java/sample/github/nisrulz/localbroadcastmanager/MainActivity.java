package sample.github.nisrulz.localbroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btn = (Button) findViewById(R.id.button);
    btn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        startService(new Intent(MainActivity.this, MyIntentService.class));
      }
    });
  }

  // Our handler for received Intents. This will be called whenever an Intent
  // with an action named "custom-event-name" is broadcasted.
  private BroadcastReceiver messageBroadcastReceiver = new BroadcastReceiver() {
    @Override public void onReceive(Context context, Intent intent) {
      // Get extra data included in the Intent
      String message = intent.getStringExtra("message");
      Toast.makeText(MainActivity.this, "Got message: " + message, Toast.LENGTH_SHORT).show();
      Log.d("receiver", "Got message: " + message);
    }
  };

  @Override protected void onPause() {
    // Unregister since the activity is paused.
    LocalBroadcastManager.getInstance(this).unregisterReceiver(messageBroadcastReceiver);
    super.onPause();
  }

  @Override protected void onResume() {

    // Register to receive messages.
    // We are registering an observer (mMessageReceiver) to receive Intents
    // with actions named "custom-event-name".
    LocalBroadcastManager.getInstance(this)
        .registerReceiver(messageBroadcastReceiver, new IntentFilter("custom-event-name"));

    super.onResume();
  }
}
