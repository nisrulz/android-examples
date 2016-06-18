package sample.github.nisrulz.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  int numMessages = 0;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btn = (Button) findViewById(R.id.button);
    btn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        sendNotification("This is a Notification!");
        sendBigNotification("This is a Big Notification!");
      }
    });
  }

  private void sendNotification(String messageBody) {
    Intent intent = new Intent(this, MainActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    PendingIntent pendingIntent =
        PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
    Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    NotificationCompat.Builder notificationBuilder =
        new NotificationCompat.Builder(this).setContentTitle("Notification")
            .setContentText(messageBody)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent);
    NotificationManager notificationManager =
        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.notify(0, notificationBuilder.build());
  }

  private void sendBigNotification(String messageBody) {
    Intent intent = new Intent(this, MainActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    PendingIntent pendingIntent =
        PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
    Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


     /* Add Big View Specific Configuration */
    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

    String[] events = new String[6];
    events[0] = new String("This is first line....");
    events[1] = new String("This is second line...");
    events[2] = new String("This is third line...");
    events[3] = new String("This is 4th line...");
    events[4] = new String("This is 5th line...");
    events[5] = new String("This is 6th line...");

    // Sets a title for the Inbox style big view
    inboxStyle.setBigContentTitle("Big Title Details:");

    // Moves events into the big view
    for (int i = 0; i < events.length; i++) {
      inboxStyle.addLine(events[i]);
    }

    NotificationCompat.Builder notificationBuilder =
        new NotificationCompat.Builder(this).setContentTitle("Notification")
            .setContentText(messageBody)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setTicker("New Message Alert!")
            .setNumber(++numMessages)
            .setSound(defaultSoundUri)
            .setStyle(inboxStyle)
            .setContentIntent(pendingIntent);

    NotificationManager notificationManager =
        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.notify(1, notificationBuilder.build());
  }
}
