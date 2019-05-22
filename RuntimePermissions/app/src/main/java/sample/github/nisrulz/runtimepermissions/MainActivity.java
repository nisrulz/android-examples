package sample.github.nisrulz.runtimepermissions;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private final int REQUEST_CODE_CALL_PHONE = 123;
  private final String[] permissionsToReq = new String[] { Manifest.permission.CALL_PHONE };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        makeACall(true);
      }
    });
  }

  void showRationaleReqPerm() {
    // Should we show an explanation?
    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
        Manifest.permission.CALL_PHONE)) {

      // Show an explanation to the user *asynchronously* -- don't block
      // this thread waiting for the user's response! After the user
      // sees the explanation, try again to request the permission.
      new AlertDialog.Builder(this).setMessage("Permission to make calls is required")
          .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              dialogInterface.dismiss();
            }
          })
          .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              requestPerm();
            }
          })
          .create()
          .show();
    }
    else {
      // No explanation needed, we can request the permission.
      requestPerm();
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions,
      int[] grantResults) {
    if (requestCode == REQUEST_CODE_CALL_PHONE) {
      
      // Loop over all permissions requested and check if they are granted
      for (int i = 0; i < permissions.length; i++) {
        if (permissions[i].equals(Manifest.permission.CALL_PHONE)
            && grantResults[i] == PackageManager.PERMISSION_GRANTED) {
          // Donot request for permission from inside the onRequestPermissionsResult(),
          // only check for permission
          makeACall(false);
        }
        else {
          Toast.makeText(this, "Permission was Denied!", Toast.LENGTH_SHORT).show();
        }
      }
    }
  }

  private void makeACall(boolean shouldReqForPermission) {
    Intent i = new Intent(Intent.ACTION_CALL);
    i.setData(Uri.parse("tel:90990990900"));

    if (checkPerm(Manifest.permission.CALL_PHONE)) {
      Toast.makeText(this, "CALL permission available..making a call", Toast.LENGTH_SHORT).show();
      startActivity(i);
    }
    else if (shouldReqForPermission) {
      showRationaleReqPerm();
    }
  }

  //  Helper methods
  private void requestPerm() {
    ActivityCompat.requestPermissions(MainActivity.this, permissionsToReq, REQUEST_CODE_CALL_PHONE);
  }

  private boolean checkPerm(String perm) {
    return ActivityCompat.checkSelfPermission(MainActivity.this, perm)
        == PackageManager.PERMISSION_GRANTED;
  }
}
