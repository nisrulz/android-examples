package github.nisrulz.unittestingwithroboelectric;

import android.os.Build;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityTest {

  private MainActivity activity;

  @Before
  public void setup() {
    activity = Robolectric.setupActivity(MainActivity.class);
  }

  @Test
  public void validateTextViewHasText() {
    TextView tvHelloWorld = (TextView) activity.findViewById(R.id.tvHelloWorld);
    assertNotNull("TextView could not be found", tvHelloWorld);

    assertTrue("TextView contains incorrect text",
        "Hello World!".equals(tvHelloWorld.getText().toString()));

    assertNotNull(activity);
  }
}
