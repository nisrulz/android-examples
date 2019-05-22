package sample.github.nisrulz.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class NotificationUtils extends ContextWrapper {

    private NotificationManager notificationManager;

    String DEFAULT_CHANNEL_ID = "DEFAULT";

    String DEFAULT_CHANNEL_NAME = "DEFAULT CHANNEL";

    String pkgName = "notification.channel";


    public NotificationUtils(Context context) {
        super(context);
        pkgName = context.getPackageName() != null ? context.getPackageName() : pkgName;
        DEFAULT_CHANNEL_ID = pkgName + "." + DEFAULT_CHANNEL_ID.toUpperCase();
        createChannel(DEFAULT_CHANNEL_ID, DEFAULT_CHANNEL_NAME);
    }

    public void createChannel(String CHANNEL_ID, String CHANNEL_NAME) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // create android channel
            NotificationChannel newChannel = new NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            // Sets whether notifications posted to this channel should display notification lights
            newChannel.enableLights(true);
            // Sets whether notification posted to this channel should vibrate.
            newChannel.enableVibration(true);
            // Sets the notification light color for notifications posted to this channel
            newChannel.setLightColor(Color.GREEN);
            // Sets whether notifications posted to this channel appear on the lockscreen or not
            newChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            getNotificationManager().createNotificationChannel(newChannel);
        }
    }

    private NotificationManager getNotificationManager() {
        if (notificationManager == null) {
            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return notificationManager;
    }

    public void sendNotificationInChannel(int notificationId, Intent resultIntent,
            NotificationCompat.Builder builder) {
        PendingIntent pi = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent
                .FLAG_UPDATE_CURRENT);

        // for notification click action, also required on Gingerbread and below
        builder.setContentIntent(pi);

        getNotificationManager().notify(notificationId, builder.build());
    }

    public void sendNotificationInDefaultChannel(String title, String body, int notificationId) {
        Intent resultIntent = new Intent(this, MainActivity.class);
        sendNotificationInChannel(notificationId, resultIntent,
                getDefaultNotificationBuilder(title, body, DEFAULT_CHANNEL_ID));
    }


    public void sendBigNotificationInDefaultChannel(String title, String body, int notificationId) {
        Intent resultIntent = new Intent(this, MainActivity.class);
        NotificationCompat.Builder builder = getDefaultNotificationBuilder(title, body, DEFAULT_CHANNEL_ID);
        builder = convertToBigNotificationBuilder(builder);
        sendNotificationInChannel(notificationId, resultIntent, builder);
    }


    private NotificationCompat.Builder getDefaultNotificationBuilder(String title, String body, String
            channelId) {
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        return new NotificationCompat.Builder(getApplicationContext(),
                channelId)
                // set title
                .setContentTitle(title)
                // set body
                .setContentText(body)
                // set ticker
                .setTicker("Notification")
                // set notification sound
                .setSound(defaultSoundUri)
                // set small icon
                .setSmallIcon(android.R.drawable.stat_notify_more)
                // set auto cancel behaviour
                .setAutoCancel(true);
    }


    private NotificationCompat.Builder convertToBigNotificationBuilder(NotificationCompat.Builder builder) {
        /* Add Big View Specific Configuration */
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        String[] events = new String[6];
        events[0] = "This is 1st line...";
        events[1] = "This is 2nd line...";
        events[2] = "This is 3rd line...";
        events[3] = "This is 4th line...";
        events[4] = "This is 5th line...";
        events[5] = "This is 6th line...";

        // Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("Big Title Details:");

        // Moves events into the big view
        for (final String event : events) {
            inboxStyle.addLine(event);
        }

        builder.setStyle(inboxStyle);
        return builder;
    }
}

