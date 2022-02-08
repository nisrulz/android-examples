package github.nisrulz.android_lib

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

class MyLib(lifecycle: Lifecycle) : DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        println("LifecycleApplication.onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        println("LifecycleApplication.onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        println("LifecycleApplication.onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        println("LifecycleApplication.onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        println("LifecycleApplication.onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        println("LifecycleApplication.onDestroy")
    }

    init {
        lifecycle.addObserver(this)
    }
}