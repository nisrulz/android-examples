package github.nisrulz.sample.usingfirebasejobdispatcher;

import androidx.test.espresso.ViewInteraction;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

  @Rule public ActivityTestRule<MainActivity> mActivityTestRule =
      new ActivityTestRule<>(MainActivity.class);

  @Test
  public void mainActivityTest() {
    ViewInteraction appCompatTextView = onView(
        allOf(withId(android.R.id.text1), withText("Schedule a Simple Job"),
            childAtPosition(allOf(withId(R.id.listview), withParent(withId(R.id.content_main))), 0),
            isDisplayed()));
    appCompatTextView.perform(click());

    ViewInteraction textView = onView(
        allOf(withId(android.R.id.text1), withText("Schedule a Simple Job"), childAtPosition(
            allOf(withId(R.id.listview), childAtPosition(withId(R.id.content_main), 0)), 0),
            isDisplayed()));
    textView.check(matches(withText("Schedule a Simple Job")));

    ViewInteraction textView2 = onView(
        allOf(withId(android.R.id.text1), withText("Cancel the Simple Job"), childAtPosition(
            allOf(withId(R.id.listview), childAtPosition(withId(R.id.content_main), 0)), 1),
            isDisplayed()));
    textView2.check(matches(withText("Cancel the Simple Job")));

    ViewInteraction textView3 = onView(
        allOf(withId(android.R.id.text1), withText("Schedule a Complex Job"), childAtPosition(
            allOf(withId(R.id.listview), childAtPosition(withId(R.id.content_main), 0)), 2),
            isDisplayed()));
    textView3.check(matches(withText("Schedule a Complex Job")));

    ViewInteraction textView4 = onView(
        allOf(withId(android.R.id.text1), withText("Cancel the Complex Job"), childAtPosition(
            allOf(withId(R.id.listview), childAtPosition(withId(R.id.content_main), 0)), 3),
            isDisplayed()));
    textView4.check(matches(withText("Cancel the Complex Job")));

    ViewInteraction textView5 = onView(
        allOf(withId(android.R.id.text1), withText("Cancel all Jobs"), childAtPosition(
            allOf(withId(R.id.listview), childAtPosition(withId(R.id.content_main), 0)), 4),
            isDisplayed()));
    textView5.check(matches(withText("Cancel all Jobs")));

    ViewInteraction textView6 = onView(allOf(withText("UsingFirebaseJobDispatcher"),
        childAtPosition(allOf(withId(R.id.toolbar),
            childAtPosition(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class), 0)),
            0), isDisplayed()));
    textView6.check(matches(withText("UsingFirebaseJobDispatcher")));
  }

  private static Matcher<View> childAtPosition(final Matcher<View> parentMatcher,
      final int position) {

    return new TypeSafeMatcher<View>() {
      @Override
      public void describeTo(Description description) {
        description.appendText("Child at position " + position + " in parent ");
        parentMatcher.describeTo(description);
      }

      @Override
      public boolean matchesSafely(View view) {
        ViewParent parent = view.getParent();
        return parent instanceof ViewGroup && parentMatcher.matches(parent) && view.equals(
            ((ViewGroup) parent).getChildAt(position));
      }
    };
  }
}
