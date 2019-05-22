package nisrulz.github.sample.usingandroidarchcomponents;

import androidx.lifecycle.LifecycleActivity;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends LifecycleActivity {

  protected TextView clickCountText;
  protected Button button;

  private ClickCounterViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    button = findViewById(R.id.increment_button);
    clickCountText = findViewById(R.id.click_count_text);


    viewModel= ViewModelProviders.of(this).get(ClickCounterViewModel.class);

    displayClickCount(viewModel.getCount());

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        viewModel.setCount(viewModel.getCount()+1);
        displayClickCount(viewModel.getCount());
      }
    });
  }

  private void displayClickCount(int clickCount) {
    clickCountText.setText(String.valueOf(clickCount));
  }
}
