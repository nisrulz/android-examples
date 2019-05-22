package github.nisrulz.sample.ratingbar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  RatingBar ratingBar;

  TextView txtstatus;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ratingBar = (RatingBar) findViewById(R.id.ratingBar);
    txtstatus = (TextView) findViewById(R.id.txtstatus);

    ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
      @Override public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        txtstatus.setText(String.valueOf(ratingBar.getRating()));
      }
    });
  }
}
