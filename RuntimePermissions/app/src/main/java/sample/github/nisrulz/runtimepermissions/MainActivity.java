package sample.github.nisrulz.runtimepermissions;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
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
               checkForPermissionAndMakeACall();
            }
        });
    }

    void checkForPermissionAndMakeACall() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "CALL permission available..making a call", Toast.LENGTH_SHORT).show();
            makeACall();
        } else {
            requestCallPermission();
        }
    }

    void requestCallPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if(permissions[0].equals(Manifest.permission.CALL_PHONE) && grantResults[0]==
                    PackageManager.PERMISSION_GRANTED){
                makeACall();
            } else {
                Toast.makeText(this, "Permission was Denied!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void makeACall() {
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:90990990900"));
        startActivity(i);
    }
}
