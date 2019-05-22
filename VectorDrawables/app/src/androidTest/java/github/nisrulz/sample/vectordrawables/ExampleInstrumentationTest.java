package github.nisrulz.sample.vectordrawables;

import android.content.Context;
import androidx.test.InstrumentationRegistry;
import androidx.test.filters.MediumTest;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@MediumTest @RunWith(AndroidJUnit4.class) public class ExampleInstrumentationTest {
  @Test public void useAppContext() throws Exception {
    // Context of the app under test.
    Context appContext = InstrumentationRegistry.getTargetContext();

    assertEquals("github.nisrulz.sample.vectordrawables", appContext.getPackageName());
  }
}