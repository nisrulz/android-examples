package nisrulz.github.example.radiobutton;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private RadioGroup radioGroup;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    /* Initialize Radio Group and attach click handler */
    radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    radioGroup.clearCheck();

    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        RadioButton rb = (RadioButton) radioGroup.findViewById(checkedId);
        if(null!=rb && checkedId > -1){
          Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
        }
      }
    });
  }

  public void onClear(View v) {
        /* Clears all selected radio buttons to default */
    radioGroup.clearCheck();
  }

  public void onSubmit(View v) {
    RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
    Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
  }
}
