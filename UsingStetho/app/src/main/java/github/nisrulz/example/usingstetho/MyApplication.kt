package github.nisrulz.example.usingstetho

import android.app.Application
import com.facebook.stetho.Stetho

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // https://github.com/facebook/stetho
        // Just start your app and point your laptop browser
        // to chrome://inspect. Click the "Inspect" button to begin.
        Stetho.initializeWithDefaults(this)
    }
}