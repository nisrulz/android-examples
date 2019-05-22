package github.nisrulz.sample.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Use a handler to delay code execution
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        // Start the MainActivity
        startActivity(new Intent(SplashActivity.this, MainActivity.class));

        // Close this activity
        finish();
      }
    }, 2000);
  }
}
