package github.nisrulz.sample.buildvariants;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    StringBuilder information = new StringBuilder();
    information.append(Info.getTypeOfBuidl())
        .append("\n\n")
        .append("Package Name :")
        .append("\n")
        .append(getPackageName())
        .append("\n\n")
        .append("Is Debuggable : ")
        .append("\n")
        .append(DebugInfo.isDebuggable());

    TextView textView = (TextView) findViewById(R.id.text);
    textView.setText(information.toString());

    Logger.logd("This is Debug Message");
    Logger.loge(new RuntimeException("This is Exception Message"));
  }
}
