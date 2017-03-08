package nisrulz.github.sample.callsandsms;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initView();

    telephonyManager =
        (TelephonyManager) getSystemService(getApplicationContext().TELEPHONY_SERVICE);
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
          if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
              == PackageManager.PERMISSION_GRANTED) {
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

  PhoneStateListener phoneStateListener = new PhoneStateListener() {
    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
      super.onCallStateChanged(state, incomingNumber);

      switch (state) {
        case TelephonyManager.CALL_STATE_IDLE:
          Toast.makeText(MainActivity.this, "CALL_STATE_IDLE", Toast.LENGTH_SHORT).show();
          break;
        case TelephonyManager.CALL_STATE_RINGING:
          Toast.makeText(MainActivity.this, "CALL_STATE_RINGING", Toast.LENGTH_SHORT).show();
          break;
        case TelephonyManager.CALL_STATE_OFFHOOK:
          Toast.makeText(MainActivity.this, "CALL_STATE_OFFHOOK", Toast.LENGTH_SHORT).show();
          break;
      }
    }
  };
}
