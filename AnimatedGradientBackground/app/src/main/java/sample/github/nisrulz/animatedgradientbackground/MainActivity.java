package sample.github.nisrulz.animatedgradientbackground;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  private ConstraintLayout constraintLayout;
  private AnimationDrawable animationDrawable;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getSupportActionBar().hide();

    // init constraintLayout
    constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

    // initializing animation drawable by getting background from constraint layout
    animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

    // setting enter fade animation duration to 5 seconds
    animationDrawable.setEnterFadeDuration(5000);

    // setting exit fade animation duration to 2 seconds
    animationDrawable.setExitFadeDuration(2000);
  }

  @Override
  protected void onResume() {
    super.onResume();
    if (animationDrawable != null && !animationDrawable.isRunning()) {
      // start the animation
      animationDrawable.start();
    }
  }

  @Override
  protected void onPause() {
    super.onPause();
    if (animationDrawable != null && animationDrawable.isRunning()) {
      // stop the animation
      animationDrawable.stop();
    }
  }
}