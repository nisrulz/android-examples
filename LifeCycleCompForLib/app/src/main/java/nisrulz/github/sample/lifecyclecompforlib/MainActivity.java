package nisrulz.github.sample.lifecyclecompforlib;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import nisrulz.github.sample.awesomelib.AwesomeLibMain;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Add Lifecycle Observer
    getLifecycle().addObserver(AwesomeLibMain.getInstance());
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    // Remove Lifecycle Observer
    getLifecycle().removeObserver(AwesomeLibMain.getInstance());
  }
}
