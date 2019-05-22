package github.nisrulz.viewpager;

import android.os.Build;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare ViewPager
        ViewPager myVP = new ViewPager(this);
        // Set ID of viewpager
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            myVP.setId(Util.generateViewId());
        } else {
            myVP.setId(View.generateViewId());
        }

        // Get a reference to LinearLayout of the activity
        LinearLayout linL =
                (LinearLayout) findViewById(R.id.container);
        linL.addView(myVP);
        // Set the adapter
        myVP.setAdapter(new MyFragmentPagerAdapter(
                getSupportFragmentManager()));
        // Set the on page change listener
        myVP.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // set page transformer for animation
        myVP.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float position) {
                int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();

                if (position < -1) { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    Util.setAlpha(view, 0);
                } else if (position <= 1) { // Page to the left, page centered, page to the right
                    // modify page view animations here for pages in view
                } else { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    Util.setAlpha(view, 0);
                }
            }
        });
    }
}