package github.nisrulz.intents;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ShareCompat;
import java.io.File;


public class ImplicitIntents {

    void openAppPageInPlaystore(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + context.getPackageName()));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    void openUrlInBrowser(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    void sendEmail(Context context, String[] sendTo, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, sendTo);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(Intent.createChooser(intent, ""));
        }
    }

    void call(Context context, String number) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
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

        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    void sendSMS(Context context, String sendToNumber, String message) {
        Uri smsUri = Uri.parse("tel:" + sendToNumber);
        Intent intent = new Intent(Intent.ACTION_VIEW, smsUri);
        intent.putExtra("address", sendToNumber);
        intent.putExtra("sms_body", message);
        intent.setType("vnd.android-dir/mms-sms");

        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    void showLocationInMap(Context context, String latitude, String longitude, String zoomLevel) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String data = String.format("geo:%s,%s", latitude, longitude);
        if (zoomLevel != null) {
            data = String.format("%s?z=%s", data, zoomLevel);
        }
        intent.setData(Uri.parse(data));

        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    void showLocationInMap(Context context, String locationName) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + locationName));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }


    void takeAPic(Context context, String dir, String fileName) {
        Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().toString() + "/" + dir, fileName));
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    void shareData(Context context, String dir, String fileName, String type, String data) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(type);
        Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().toString() + "/" + dir, fileName));
        intent.putExtra(Intent.EXTRA_STREAM, uri.toString());
        intent.putExtra("data", data);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(Intent.createChooser(intent, "Share using"));
        }
    }


    void shareText(Activity activity, String title, String textData) {
        ShareCompat.IntentBuilder.from(activity).setType("text/plain").setChooserTitle(title)
                .setText(textData).startChooser();
    }
}

