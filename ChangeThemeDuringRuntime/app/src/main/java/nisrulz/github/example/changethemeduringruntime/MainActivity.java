package nisrulz.github.example.changethemeduringruntime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {

    // Call setTheme before supper constructor and setContentView
    setTheme(getFlag() ? R.style.AppThemeDark : R.style.AppThemeLight);

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btn_change = (Button) findViewById(R.id.btn_change);
    btn_change.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {

        // Flip the flag
        saveFlag(!getFlag());

        // Restart the same activity
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
      }
    });
  }

  private void saveFlag(boolean flag) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putBoolean("dark", flag);
    editor.commit();
  }

  private boolean getFlag() {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    return preferences.getBoolean("dark", false);
  }
}
