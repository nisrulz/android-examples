package nisrulz.github.sample.awesomelib

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class AwesomeLibMain private constructor() : DefaultLifecycleObserver {

  override fun onCreate(owner: LifecycleOwner) {
    super.onCreate(owner)
    println(
        "Called From AwesomeLibMain Class, called onCreate() of Activity")
  }

  override fun onResume(owner: LifecycleOwner) {
    super.onResume(owner)
    println(
        "Called From AwesomeLibMain Class, called onResume() of Activity")
  }

  override fun onPause(owner: LifecycleOwner) {
    super.onPause(owner)
    println(
        "Called From AwesomeLibMain Class, called onPause() of Activity")
  }

  override fun onStart(owner: LifecycleOwner) {
    super.onStart(owner)

    println(
        "Called From AwesomeLibMain Class, called onStart() of Activity")
  }

  override fun onStop(owner: LifecycleOwner) {
    super.onStop(owner)
    println(
        "Called From AwesomeLibMain Class, called onStop() of Activity")
  }

  override fun onDestroy(owner: LifecycleOwner) {
    super.onDestroy(owner)
    println(
        "Called From AwesomeLibMain Class, called onDestroy() of Activity")
  }

  companion object {
    val instance = AwesomeLibMain()
  }
}