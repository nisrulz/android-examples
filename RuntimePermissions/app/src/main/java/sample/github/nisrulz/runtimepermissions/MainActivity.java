package sample.github.nisrulz.runtimepermissions;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

  void requestCallPermission() {
    // Should we show an explanation?
    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
        Manifest.permission.CALL_PHONE)) {

      // Show an expanation to the user *asynchronously* -- don't block
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
              ActivityCompat.requestPermissions(MainActivity.this,
                  new String[] { Manifest.permission.CALL_PHONE }, 1);
            }
          })
          .create()
          .show();
    }
    else {
      // No explanation needed, we can request the permission.
      ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CALL_PHONE }, 1);
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions,
      int[] grantResults) {
    if (requestCode == 1) {
      if (permissions[0].equals(Manifest.permission.CALL_PHONE)
          && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        // Donot request for permission from inside the onRequestPermissionsResult(), only check for permission
        makeACall(false);
      }
      else {
        Toast.makeText(this, "Permission was Denied!", Toast.LENGTH_SHORT).show();
      }
    }
  }

  private void makeACall(boolean requestPermission) {
    Intent i = new Intent(Intent.ACTION_CALL);
    i.setData(Uri.parse("tel:90990990900"));

    if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
        == PackageManager.PERMISSION_GRANTED) {
      Toast.makeText(this, "CALL permission available..making a call", Toast.LENGTH_SHORT).show();
      startActivity(i);
    }
    else if (requestPermission) {
      requestCallPermission();
    }
  }
}
