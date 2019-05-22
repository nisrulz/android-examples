package nisrulz.github.sample.callsandsms;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private EditText etPhoneNo;
  private Button btnDial;
  private Button btnCall;
  private TelephonyManager telephonyManager;
  private EditText etMessage;
  private Button btnSendMessage;
  private Button btnSendMessageDirectly;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    checkIfPermissionGranted();

    initView();

    telephonyManager =
        (TelephonyManager) getSystemService(getApplicationContext().TELEPHONY_SERVICE);
  }

  boolean isPermissionGranted(String permission) {
    return ContextCompat.checkSelfPermission(MainActivity.this, permission)
        == PackageManager.PERMISSION_GRANTED;
  }

  void checkIfPermissionGranted() {
    if (isPermissionGranted(Manifest.permission.CALL_PHONE)
        || isPermissionGranted(Manifest.permission.SEND_SMS)
        || isPermissionGranted(Manifest.permission.RECEIVE_SMS)
        || isPermissionGranted(Manifest.permission.READ_PHONE_STATE)
        || isPermissionGranted(Manifest.permission.PROCESS_OUTGOING_CALLS)) {

      // Request runtime permission
      ActivityCompat.requestPermissions(this, new String[] {
          Manifest.permission.CALL_PHONE, Manifest.permission.SEND_SMS,
          Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_PHONE_STATE,
          Manifest.permission.PROCESS_OUTGOING_CALLS
      }, 100);
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
  }

  private void initView() {
    etPhoneNo = (EditText) findViewById(R.id.et_phone_no);
    btnDial = (Button) findViewById(R.id.btn_dial);
    btnCall = (Button) findViewById(R.id.btn_call);

    btnDial.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String phoneNo = etPhoneNo.getText().toString();
        if (!TextUtils.isEmpty(phoneNo)) {
          String dial = "tel:" + phoneNo;
          startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
        }
        else {
          Toast.makeText(MainActivity.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
        }
      }
    });

    btnCall.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String phoneNo = etPhoneNo.getText().toString();
        if (!TextUtils.isEmpty(phoneNo)) {
          String dial = "tel:" + phoneNo;

          // Requires Permission to be declared in manifest
          // <uses-permission android:name="android.permission.CALL_PHONE"/>
          // Then check and request for permission during runtime
          if (isPermissionGranted(Manifest.permission.CALL_PHONE)) {
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
          }
          else {
            Toast.makeText(MainActivity.this, "Permission not granted yet!", Toast.LENGTH_SHORT)
                .show();
          }
        }
        else {
          Toast.makeText(MainActivity.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
        }
      }
    });

    etMessage = (EditText) findViewById(R.id.et_message);
    btnSendMessage = (Button) findViewById(R.id.btn_send_message);
    btnSendMessage.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String message = etMessage.getText().toString();
        String phoneNo = etPhoneNo.getText().toString();
        if (!TextUtils.isEmpty(message) && !TextUtils.isEmpty(phoneNo)) {
          Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNo));
          smsIntent.putExtra("sms_body", message);
          startActivity(smsIntent);
        }
      }
    });

    btnSendMessageDirectly = (Button) findViewById(R.id.btn_send_message_directly);
    btnSendMessageDirectly.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        String message = etMessage.getText().toString();
        String phoneNo = etPhoneNo.getText().toString();
        if (!TextUtils.isEmpty(message) && !TextUtils.isEmpty(phoneNo)) {
          // Requires Permission to be declared in manifest
          // <uses-permission android:name="android.permission.SEND_SMS"/>
          // Then check and request for permission during runtime
          if (isPermissionGranted(Manifest.permission.SEND_SMS)) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
          }
          else {
            Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
          }
        }
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();

    telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
  }

  @Override
  protected void onStop() {
    super.onStop();
    telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE);
  }

  // This listener only works when the app is in foreground
  PhoneStateListener phoneStateListener = new PhoneStateListener() {
    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
      super.onCallStateChanged(state, incomingNumber);

      switch (state) {
        case TelephonyManager.CALL_STATE_IDLE:
          Toast.makeText(MainActivity.this, "CALL_STATE_IDLE : Detected in FG", Toast.LENGTH_SHORT)
              .show();
          break;
        case TelephonyManager.CALL_STATE_RINGING:
          Toast.makeText(MainActivity.this, "CALL_STATE_RINGING : Detected in FG",
              Toast.LENGTH_SHORT).show();
          break;
        case TelephonyManager.CALL_STATE_OFFHOOK:
          Toast.makeText(MainActivity.this, "CALL_STATE_OFFHOOK : Detected in FG",
              Toast.LENGTH_SHORT).show();
          break;
      }
    }
  };
}
