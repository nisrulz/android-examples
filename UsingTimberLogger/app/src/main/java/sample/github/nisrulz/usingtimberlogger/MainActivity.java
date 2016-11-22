package sample.github.nisrulz.usingtimberlogger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Timber.d("Hello");
    Timber.w("World!");
  }
}
