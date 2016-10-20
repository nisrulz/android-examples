package io.github.the_dagger.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * You can also implement something similar by inflating the menu item and adding it to the bottomNavigationVIew object.
         * You can then add that object to the root of the layout.
         */
//        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
//        BottomNavigationView bottomNavigationView = new BottomNavigationView(this);
//        bottomNavigationView.inflateMenu(R.menu.my_navigation_items);
//        relativeLayout.addView(bottomNavigationView);
        textView = (TextView) findViewById(R.id.text_view);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_camera :
                        textView.setText(item.getTitle());
                        /**
                         * Do some selection specific task here.
                         */
                        break;
                    case R.id.nav_gallery :
                        textView.setText(item.getTitle());
                        break;
                    case R.id.nav_manage :
                        textView.setText(item.getTitle());
                        break;
                    case R.id.nav_slideshow :
                        textView.setText(item.getTitle());
                        break;
                }
                return true;
            }
        });
    }
}
