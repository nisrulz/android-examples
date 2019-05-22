package nisrulz.github.sample.compileonly;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import nisrulz.github.sample.awesomelib.AwesomeLibMain;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Create an instance of AwesomeLib
    AwesomeLibMain awesomeLibMain = new AwesomeLibMain();

    TextView txt = findViewById(R.id.textView);
    // Use the init() method to get the boolean value for is Retrofit on Classpath
    boolean hasRetrofitOnClasspath = awesomeLibMain.init();
    txt.setText("isRetrofitAvailable in Classpath: " + String.valueOf(hasRetrofitOnClasspath));
  }
}
