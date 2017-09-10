package nisrulz.github.sample.lifecyclecompforlib;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import nisrulz.github.sample.awesomelib.AwesomeLibMain;

public class MainActivity extends LifecycleActivity {

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
