package github.nisrulz.sample.usingprocesslifecycleownerforlibs;

import android.app.Application;
import androidx.lifecycle.ProcessLifecycleOwner;
import github.nisrulz.sample.lib.MyLib;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // setup process lifecycle tracking
        MyLib myLib = new MyLib(ProcessLifecycleOwner.get().getLifecycle());

    }
}
