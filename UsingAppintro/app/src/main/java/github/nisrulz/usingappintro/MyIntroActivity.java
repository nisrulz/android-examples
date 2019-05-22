package github.nisrulz.usingappintro;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import android.view.WindowManager;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class MyIntroActivity extends AppIntro2 {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Make it fullscreen
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    // Define Titles
    String[] titles = {
        getResources().getString(R.string.title_1), getResources().getString(R.string.title_2),
        getResources().getString(R.string.title_3), getResources().getString(R.string.title_4)
    };

    // Define Descriptions
    String[] desc = {
        getResources().getString(R.string.desc_1), getResources().getString(R.string.desc_2),
        getResources().getString(R.string.desc_3), getResources().getString(R.string.desc_4)
    };

    // Define Images
    int[] image = {
        R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4
    };

    // Define Colors
    int[] color = {
        ContextCompat.getColor(this, R.color.colorPrimary),
        ContextCompat.getColor(this, R.color.colorAccent),
        ContextCompat.getColor(this, R.color.colorPrimary),
        ContextCompat.getColor(this, R.color.colorPrimaryDark)
    };

    // Start Adding Intro Slides
    addSlide(AppIntroFragment.newInstance(titles[0], desc[0], image[0], color[0]));
    addSlide(AppIntroFragment.newInstance(titles[1], desc[1], image[1], color[1]));
    addSlide(AppIntroFragment.newInstance(titles[2], desc[2], image[2], color[2]));
    addSlide(AppIntroFragment.newInstance(titles[3], desc[3], image[3], color[3]));

    // Hide Skip/Done button.
    showSkipButton(true);
    setProgressButtonEnabled(true);

    // Turn vibration on and set intensity.
    // NOTE: you will probably need to ask VIBRATE permission in Manifest.
    setVibrate(true);
    setVibrateIntensity(30);

    // Available Slide Change Animations
    //setFadeAnimation();
    //setZoomAnimation();
    //setFlowAnimation();
    //setSlideOverAnimation();
    setDepthAnimation();
  }

  @Override
  public void onSkipPressed(Fragment currentFragment) {
    super.onSkipPressed(currentFragment);
    // Do something when users tap on Skip button.

    startMainActivity();
  }

  @Override
  public void onDonePressed(Fragment currentFragment) {
    super.onDonePressed(currentFragment);
    // Do something when users tap on Done button.

    startMainActivity();
  }

  @Override
  public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
    super.onSlideChanged(oldFragment, newFragment);
    // Do something when the slide changes.
  }

  private void startMainActivity() {
    // Start the MainActivity and close this activity
    startActivity(new Intent(MyIntroActivity.this, MainActivity.class));
    finish();
  }
}
