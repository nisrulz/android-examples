package sample.github.nisrulz.usingtimberlogger;

import android.util.Log;
import timber.log.Timber;

public class ReleaseTree extends Timber.Tree {

  @Override
  protected boolean isLoggable(String tag, int priority) {
    if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
      return false;
    }

    // Only log WARN, ERROR, WTF
    return true;
  }

  @Override
  protected void log(int priority, String tag, String message, Throwable t) {

    if (isLoggable(tag, priority)) {

      // Report all caught exceptions to crashlytics
      if (priority == Log.ERROR && t != null) {
        // Crashlytics.log(t)
      }
    }
  }
}
