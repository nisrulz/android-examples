package github.nisrulz.sample.ratingbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  RatingBar ratingBar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ratingBar = (RatingBar) findViewById(R.id.ratingBar);

    ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
      @Override public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        Toast.makeText(MainActivity.this, String.valueOf(v), Toast.LENGTH_SHORT).show();
      }
    });
  }
}
