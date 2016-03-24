package github.nisrulz.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author Nishant Srivastava
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Page.newInstance(0, "Zeroth : Page Type 1");
            case 1:
                return Page2.newInstance(1, "One : Page Type 2");
            case 2:
                return Page.newInstance(2, "Two : Page Type 1");
            default:
                return Page2.newInstance(3, "Default : Page Type 2");
        }

    }
}
