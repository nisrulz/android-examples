package nisrulz.github.sample.awesomelib;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

public class AwesomeLibMain implements LifecycleObserver {
  static final AwesomeLibMain ourInstance = new AwesomeLibMain();

  public static AwesomeLibMain getInstance() {
    return ourInstance;
  }

  private AwesomeLibMain() {
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public void init() {
    System.out.println(
        "Called From AwesomeLibMain Class, called onCreate() of Activity >>>>>> init()");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public void LibOnStart() {
    System.out.println(
        "Called From AwesomeLibMain Class, called onStart() of Activity >>>>>> LibOnStart()");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void LibOnStop() {
    System.out.println(
        "Called From AwesomeLibMain Class, called onStop() of Activity >>>>>> LibOnStop()");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void LibOnResume() {
    System.out.println(
        "Called From AwesomeLibMain Class, called onResume() of Activity >>>>>> LibOnResume()");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void LibOnPause() {
    System.out.println(
        "Called From AwesomeLibMain Class, called onPause() of Activity >>>>>> LibOnPause()");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void cleanup() {
    System.out.println(
        "Called From AwesomeLibMain Class, called onDestroy() of Activity >>>>>> cleanup()");
  }
}
