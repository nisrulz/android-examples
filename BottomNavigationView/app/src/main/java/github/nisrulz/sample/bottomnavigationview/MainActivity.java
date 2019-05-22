package github.nisrulz.sample.bottomnavigationview;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final TextView textView = (TextView) findViewById(R.id.textView);

    // Declare and reference the bottom navigation view
    BottomNavigationView bottomNavigationView =
        (BottomNavigationView) findViewById(R.id.bottom_navigation);

    //Attach the listener
    bottomNavigationView.setOnNavigationItemSelectedListener(
        new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
              case R.id.update_item:
                textView.setText("Update Item Selected");
                break;
              case R.id.location_item:
                textView.setText("Location Item Selected");
                break;
              case R.id.favorite_item:
                textView.setText("Favorite Item Selected");
                break;
            }
            return true;
          }
        });
  }
}
