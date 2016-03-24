package github.nisrulz.intents;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;

import java.io.File;


public class ImplicitIntents {

    void openAppPageInPlaystore(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + context.getPackageName()));
        context.startActivity(intent);
    }

    void openUrlInBrowser(Context context, String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(browserIntent);
    }

    void sendEmail(Context context, String[] sendTo, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, sendTo);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        context.startActivity(Intent.createChooser(intent, ""));
    }

    void call(Context context, String number) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        context.startActivity(callIntent);
    }

    void sendSMS(Context context, String sendToNumber, String message) {
        Uri smsUri = Uri.parse("tel:" + sendToNumber);
        Intent intent = new Intent(Intent.ACTION_VIEW, smsUri);
        intent.putExtra("address", sendToNumber);
        intent.putExtra("sms_body", message);
        intent.setType("vnd.android-dir/mms-sms");
        context.startActivity(intent);
    }

    void showLocationInMap(Context context, String latitude, String longitude, String zoomLevel) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String data = String.format("geo:%s,%s", latitude, longitude);
        if (zoomLevel != null) {
            data = String.format("%s?z=%s", data, zoomLevel);
        }
        intent.setData(Uri.parse(data));
        context.startActivity(intent);
    }


    void takeAPic(Context context, String dir, String fileName) {
        Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().toString() + "/" + dir, fileName));
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        context.startActivity(intent);
    }

    void shareData(Context context, String dir, String fileName, String type, String data) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType(type);
        Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().toString() + "/" + dir, fileName));
        sharingIntent.putExtra(Intent.EXTRA_STREAM, uri.toString());
        sharingIntent.putExtra("data", data);
        context.startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }
}

