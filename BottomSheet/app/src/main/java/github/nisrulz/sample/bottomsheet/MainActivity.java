package github.nisrulz.sample.bottomsheet;

import android.os.Bundle;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  private BottomSheetBehavior mBottomSheetBehavior;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    View bottomSheet = findViewById(R.id.bottom_sheet);
    Button button1 = (Button) findViewById(R.id.button_1);
    Button button2 = (Button) findViewById(R.id.button_2);
    Button button3 = (Button) findViewById(R.id.button_3);

    mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
    // Set it as collapsed initially
    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // Expand
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
      }
    });
    button2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // Collapse
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
      }
    });
    button3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        // Peek
        mBottomSheetBehavior.setPeekHeight(300);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
      }
    });

    // Make peeking gone when completely collapsed
    mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
      @Override
      public void onStateChanged(View bottomSheet, int newState) {
        if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
          mBottomSheetBehavior.setPeekHeight(0);
        }
      }

      @Override
      public void onSlide(View bottomSheet, float slideOffset) {
      }
    });
  }
}
