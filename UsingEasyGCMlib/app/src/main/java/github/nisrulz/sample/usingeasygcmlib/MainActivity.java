package github.nisrulz.sample.usingeasygcmlib;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import eu.inloop.easygcm.EasyGcm;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Set logging ;evel
    EasyGcm.setLoggingLevel(EasyGcm.Logger.LEVEL_WARNING);
    // Init EasyGCM
    EasyGcm.init(this);
  }
}
