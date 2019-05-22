package github.nisrulz.sample.vectordrawables;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ImageView imgvw = (ImageView) findViewById(R.id.imgvw);
    // Programmatically loading vector drawable
    imgvw.setImageResource(R.drawable.ic_adb_black_24dp);
  }
}
