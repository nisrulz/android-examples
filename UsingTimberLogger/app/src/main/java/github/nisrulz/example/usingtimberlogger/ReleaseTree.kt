package github.nisrulz.example.usingtimberlogger

import android.util.Log
import timber.log.Timber

class ReleaseTree : Timber.Tree() {
    override fun isLoggable(tag: String?, priority: Int): Boolean {
        // Only log WARN, ERROR, WTF
        return !(priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO)
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (isLoggable(tag, priority)) {

            // Report all caught exceptions to crashlytics
            if (priority == Log.ERROR && t != null) {
                // Crashlytics.log(t)
            }
        }
    }
}