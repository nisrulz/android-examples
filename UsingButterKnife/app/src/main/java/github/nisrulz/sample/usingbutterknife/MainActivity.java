package github.nisrulz.sample.usingbutterknife;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.textView) TextView textView;
  @BindView(R.id.button) Button button;
  @BindView(R.id.editText) EditText editText;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Required for integration of ButterKnife
    ButterKnife.bind(this);

    // Use the bound views
    textView.setText("Hello , I am TextView");

    button.setText("Submit");

    editText.setHint("Hello , I am EditText");
  }



  @OnClick(R.id.button)
  public void submit() {
    Toast.makeText(MainActivity.this, "Button was Hit!", Toast.LENGTH_SHORT).show();
  }
}
