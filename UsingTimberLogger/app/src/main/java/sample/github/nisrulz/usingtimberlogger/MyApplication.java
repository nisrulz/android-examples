package sample.github.nisrulz.usingtimberlogger;

import android.app.Application;
import timber.log.Timber;

public class MyApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree() {
        // Add line numbers to logs
        @Override
        protected String createStackElementTag(StackTraceElement element) {
          return super.createStackElementTag(element) + ":" + element.getLineNumber();
        }
      });
    }
    else {
      // Release Mode
      // Init your Crashlytics here
      Timber.plant(new ReleaseTree());
    }
  }
}
