package github.nisrulz.sample.usingbottomnavigationbar;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainActivity extends AppCompatActivity {

  private String LOGTAG = "UsingBottomNavigationBar";
  // Using lib from : https://github.com/roughike/BottomBar
  private BottomBar mBottomBar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mBottomBar = BottomBar.attach(this, savedInstanceState);
    mBottomBar.setItemsFromMenu(R.menu.bottombar_menu, new OnMenuTabClickListener() {
      @Override public void onMenuTabSelected(@IdRes int menuItemId) {
        switch (menuItemId) {
          case R.id.bottomBarItem1:
            Log.d(LOGTAG, "The user selected item number one");
            break;
          case R.id.bottomBarItem2:
            Log.d(LOGTAG, "The user selected item number two");
            break;
          case R.id.bottomBarItem3:
            Log.d(LOGTAG, "The user selected item number three");
            break;
          case R.id.bottomBarItem4:
            Log.d(LOGTAG, "The user selected item number four");
            break;
        }
      }

      @Override public void onMenuTabReSelected(@IdRes int menuItemId) {
        switch (menuItemId) {
          case R.id.bottomBarItem1:
            Log.d(LOGTAG, "The user reselected item number one, scroll your content to top.");
            break;
          case R.id.bottomBarItem2:
            Log.d(LOGTAG, "The user reselected item number two, scroll your content to top.");
            break;
          case R.id.bottomBarItem3:
            Log.d(LOGTAG, "The user reselected item number three, scroll your content to top.");
            break;
          case R.id.bottomBarItem4:
            Log.d(LOGTAG, "The user reselected item number four, scroll your content to top.");
            break;
        }
      }
    });

    // Setting colors for different tabs when there's more than three of them.
    // You can set colors for tabs in three different ways as shown below.
    mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
    mBottomBar.mapColorForTab(1, 0xFF5D4037);
    mBottomBar.mapColorForTab(2, "#7B1FA2");
    mBottomBar.mapColorForTab(3, "#FF5252");
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);

    // Necessary to restore the BottomBar's state, otherwise we would
    // lose the current tab on orientation change.
    mBottomBar.onSaveInstanceState(outState);
  }
}
