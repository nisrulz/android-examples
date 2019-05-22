package github.nisrulz.sample.gcmnetworkmanager;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  GCMNetMUtil gcmNetMUtil;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    gcmNetMUtil = new GCMNetMUtil(this);

    // One Off Task
    gcmNetMUtil.oneOffTask();

    // Periodic Task
    gcmNetMUtil.periodicTask();
  }

  @Override protected void onDestroy() {
    super.onDestroy();

    gcmNetMUtil.cancelAllTasks();
  }
}
