package github.nisrulz.sample.usingrobolectric.support;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewLocator {

  public static TextView getTextView(Activity activity, int viewId) {
    return (TextView) activity.findViewById(viewId);
  }

  public static EditText getEditText(Activity activity, int viewId) {
    return (EditText) activity.findViewById(viewId);
  }

  public static Button getButton(Activity activity, int viewId) {
    return (Button) activity.findViewById(viewId);
  }
}
