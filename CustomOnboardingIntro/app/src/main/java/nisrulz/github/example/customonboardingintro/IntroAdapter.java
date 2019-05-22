package nisrulz.github.example.customonboardingintro;

import android.graphics.Color;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class IntroAdapter extends FragmentPagerAdapter {

  public IntroAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return IntroFragment.newInstance(Color.parseColor("#03A9F4"), position); // blue
      default:
        return IntroFragment.newInstance(Color.parseColor("#4CAF50"), position); // green
    }
  }

  @Override public int getCount() {
    return 2;
  }
}
