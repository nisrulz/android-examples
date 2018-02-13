package github.nisrulz.sample.lib;

import android.arch.lifecycle.DefaultLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

public class MyLib implements DefaultLifecycleObserver {

    public MyLib(final Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    @Override
    public void onCreate(@NonNull final LifecycleOwner owner) {
        System.out.println("LifecycleApplication.onCreate");
    }

    @Override
    public void onStart(@NonNull final LifecycleOwner owner) {
        System.out.println("LifecycleApplication.onStart");

    }

    @Override
    public void onResume(@NonNull final LifecycleOwner owner) {
        System.out.println("LifecycleApplication.onResume");
    }

    @Override
    public void onPause(@NonNull final LifecycleOwner owner) {
        System.out.println("LifecycleApplication.onPause");
    }

    @Override
    public void onStop(@NonNull final LifecycleOwner owner) {
        System.out.println("LifecycleApplication.onStop");
    }

    @Override
    public void onDestroy(@NonNull final LifecycleOwner owner) {
        System.out.println("LifecycleApplication.onDestroy");
    }
}