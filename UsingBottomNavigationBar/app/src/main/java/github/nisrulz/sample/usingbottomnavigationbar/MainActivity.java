package github.nisrulz.sample.usingbottomnavigationbar;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

  private String LOGTAG = "BottomNavigationBar";
  // Using lib from : https://github.com/roughike/BottomBar
  private BottomBar bottomBar;

  private TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.text_view);

    bottomBar = (BottomBar) findViewById(R.id.bottomBar);
    bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
      @Override
      public void onTabSelected(@IdRes int tabId) {
        switch (tabId) {
          case R.id.bottomBarItem1:
            logData("1");
            break;
          case R.id.bottomBarItem2:
            logData("2");
            break;
          case R.id.bottomBarItem3:
            logData("3");
            break;
          case R.id.bottomBarItem4:
            logData("4");
            break;
        }
      }
    });

    BottomBarTab accountTab = bottomBar.getTabWithId(R.id.bottomBarItem2);
    accountTab.setBadgeCount(5);

    // Remove Badge when done
    //accountTab.removeBadge();

    bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
      @Override
      public void onTabReSelected(@IdRes int tabId) {
        switch (tabId) {
          case R.id.bottomBarItem1:
            logData("1 (Re)");
            break;
          case R.id.bottomBarItem2:
            logData("2 (Re)");
            break;
          case R.id.bottomBarItem3:
            logData("3 (Re)");
            break;
          case R.id.bottomBarItem4:
            logData("4 (Re)");
            break;
        }
      }
    });
  }

  private void logData(String data) {
    String msg = "Selected Tab - " + data;
    textView.setText(msg);
    Log.d(LOGTAG, msg);
  }
}
