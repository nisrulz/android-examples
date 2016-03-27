package github.nisrulz.usingstetho;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // http://facebook.github.io/stetho/
        Stetho.initializeWithDefaults(this);
    }
}
