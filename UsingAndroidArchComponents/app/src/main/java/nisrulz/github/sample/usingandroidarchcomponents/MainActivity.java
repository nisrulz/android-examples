package nisrulz.github.sample.usingandroidarchcomponents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  protected TextView clickCountText;
  protected Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    button = findViewById(R.id.increment_button);
    clickCountText = findViewById(R.id.click_count_text);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        int currentClickCount = Integer.parseInt(clickCountText.getText().toString());
        clickCountText.setText(String.valueOf(++currentClickCount));
      }
    });
  }
}
