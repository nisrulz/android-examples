package nisrulz.github.example.customonboardingintro;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private ViewPager mViewPager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    setContentView(R.layout.activity_main);

    mViewPager = (ViewPager) findViewById(R.id.viewpager);

    // Set an Adapter on the ViewPager
    mViewPager.setAdapter(new IntroAdapter(getSupportFragmentManager()));

    // Set a PageTransformer
    mViewPager.setPageTransformer(false, new IntroPageTransformer());
  }
}
