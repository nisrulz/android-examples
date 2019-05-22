package nisrulz.github.example.sharedelementtransitions;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    CardView cardView = (CardView) findViewById(R.id.card_view);
    cardView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        animateIntent(view);
      }
    });
  }

  public void animateIntent(View view) {

    // Ordinary Intent for launching a new activity
    Intent intent = new Intent(this, Main2Activity.class);

    // Get the transition name from the string
    String transitionName = getString(R.string.transition_string);

    // Define the view that the animation will start from
    View viewStart = findViewById(R.id.card_view);

    ActivityOptionsCompat options =

        ActivityOptionsCompat.makeSceneTransitionAnimation(this, viewStart,   // Starting view
            transitionName    // The String
        );
    //Start the Intent
    ActivityCompat.startActivity(this, intent, options.toBundle());
  }
}
