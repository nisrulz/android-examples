package github.nisrulz.sample.usingrobolectric;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
  public static Intent newIntent(Context context) {
    return new Intent(context, SecondActivity.class);
  }
}
