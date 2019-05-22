package github.nisrulz.jni;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  // Load the native lib
  static {
    System.loadLibrary("hello-android-jni");
  }

  // Declare the native method here
  public native String getMsgFromJni();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView txtView = (TextView) findViewById(R.id.jni_msgView);
    // Call the method as you would normally
    String message = getMsgFromJni();
    // Set in textview
    txtView.setText(message);
  }
}
