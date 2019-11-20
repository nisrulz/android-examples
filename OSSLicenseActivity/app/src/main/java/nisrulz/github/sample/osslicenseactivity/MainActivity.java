package nisrulz.github.sample.osslicenseactivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.oss.licenses.OssLicensesMenuActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btn_oss = findViewById(R.id.btn_oss);
    btn_oss.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        // Add a custom title to the activity
        String title = getString(R.string.custom_license_title);
        OssLicensesMenuActivity.setActivityTitle(title);

        // OssLicensesMenuActivity is provided by google play services, just start the activity
        Intent intent = new Intent(MainActivity.this, OssLicensesMenuActivity.class);
        startActivity(intent);
      }
    });
  }
}
