package nisrulz.github.example.usinglitho;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.Text;

import static android.graphics.Typeface.BOLD;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final ComponentContext context = new ComponentContext(this);

    final Component component = Text.create(context)
        .text("Hello World!")
        .textColor(Color.BLUE)
        .textSizeDip(40)
        .textStyle(BOLD)
        .build();

    setContentView(LithoView.create(context, component));
  }
}
