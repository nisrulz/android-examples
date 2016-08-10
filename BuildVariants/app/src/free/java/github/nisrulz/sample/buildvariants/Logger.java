package github.nisrulz.sample.buildvariants;

import android.util.Log;

public class Logger {
  public static final String LOGTAG = "FreeBuild---------->";

  public static void logd(String message) {
    Log.d(LOGTAG, message);
  }

  public static void loge(Exception ex) {
    Log.d(LOGTAG, "Exception", ex);
  }
}
