package github.nisrulz.example.usingtimberlogger

import android.app.Application
import androidx.viewbinding.BuildConfig
import timber.log.Timber

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            // Debug Mode
            Timber.plant(LineNumberDebugTree())
        } else {
            // Release Mode
            // Init your Crashlytics here
            Timber.plant(ReleaseTree())
        }
    }
}