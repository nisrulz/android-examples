package github.nisrulz.sample.usingrobolectric;

import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static github.nisrulz.sample.usingrobolectric.support.Assert.assertViewIsVisible;
import static github.nisrulz.sample.usingrobolectric.support.ResourceLocator.getString;
import static github.nisrulz.sample.usingrobolectric.support.ViewLocator.getButton;
import static github.nisrulz.sample.usingrobolectric.support.ViewLocator.getEditText;
import static github.nisrulz.sample.usingrobolectric.support.ViewLocator.getTextView;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;
import static org.robolectric.shadows.ShadowToast.getTextOfLatestToast;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityTest {

  private MainActivity activity;
  private Button hintbutton;
  private Button loginButton;

  @Before
  public void setUp() {
    activity = Robolectric.setupActivity(MainActivity.class);
    hintbutton = getButton(activity, R.id.hintbutton);
    loginButton = getButton(activity, R.id.loginbutton);
  }

  @Test
  public void shouldNotBeNull() {
    assertNotNull(activity);
  }

  @Test
  public void shouldHaveTitle() throws Exception {
    assertThat(activity.getTitle().toString(), equalTo(getString(R.string.app_name)));
  }

  @Test
  public void shouldHaveWelcomeText() throws Exception {
    TextView textView = getTextView(activity, R.id.textview);
    assertViewIsVisible(textView);

    assertThat(textView.getText().toString(), equalTo(getString(R.string.Welcome_text)));
  }

  @Test
  public void shouldHaveNameEntry() throws Exception {
    EditText nameEntry = getEditText(activity, R.id.nameentry);

    assertViewIsVisible(nameEntry);

    assertThat(nameEntry.getHint().toString(), equalTo(getString(R.string.NAME_ENTRY_HINT)));
  }

  @Test
  public void shouldHaveLoginButton() throws Exception {
    assertViewIsVisible(loginButton);
    assertThat(loginButton.getText().toString(), equalTo(getString(R.string.LOGIN_BTN_TEXT)));
  }

  @Test
  public void shouldHaveHintButton() throws Exception {
    assertViewIsVisible(hintbutton);
    assertThat(hintbutton.getText().toString(), equalTo(getString(R.string.HINT_BTN_TEXT)));
  }

  @Test
  public void shouldShowHintWhenClicked() throws Exception {
    hintbutton.performClick();
    assertThat(getTextOfLatestToast(), equalTo(getString(R.string.HINT_TEXT)));
  }

  @Test
  public void shouldLoginWhenClicked() throws Exception {
    loginButton.performClick();

    ShadowActivity shadowActivity = shadowOf(activity);
    Intent intent = shadowActivity.getNextStartedActivity();
    ShadowIntent shadowIntent = shadowOf(intent);
    assertEquals(shadowIntent.getIntentClass().getSimpleName(),
        SecondActivity.class.getSimpleName());
  }
}