package sample.github.nisrulz.notification;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int numMessages = 0;

    public static final String PERSONAL_CHANNEL_ID = "PERSONAL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NotificationUtils notificationUtils = new NotificationUtils(this);
        notificationUtils.createChannel(PERSONAL_CHANNEL_ID, "PERSONAL");

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simple Notification
                notificationUtils.sendNotificationInDefaultChannel("Simple Notification", "Hello Simple World!", 101);

                // Big Notification
                notificationUtils.sendBigNotificationInDefaultChannel("Big Notification", "Hello BIG World!", 102);

                // Custom Notifications
                createCustomNotification(notificationUtils);
            }
        });
    }

    private void createCustomNotification(NotificationUtils notificationUtils) {
        Intent resultIntent = new Intent(MainActivity.this, MainActivity.class);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),
                PERSONAL_CHANNEL_ID)
                // set title
                .setContentTitle("Custom Notification")
                // set body
                .setContentText("Hello Custom World!")
                // set ticker
                .setTicker("Custom Notification")
                // set small icon
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                // set auto cancel behaviour
                .setAutoCancel(true);
        notificationUtils.sendNotificationInChannel(103, resultIntent, builder);
    }
}
