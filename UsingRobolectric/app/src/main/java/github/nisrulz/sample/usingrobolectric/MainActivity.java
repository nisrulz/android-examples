package github.nisrulz.sample.usingrobolectric;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.hintbutton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(MainActivity.this, R.string.HINT_TEXT, Toast.LENGTH_SHORT).show();
      }
    });

    findViewById(R.id.loginbutton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        startActivity(SecondActivity.newIntent(MainActivity.this));
      }
    });
  }
}
