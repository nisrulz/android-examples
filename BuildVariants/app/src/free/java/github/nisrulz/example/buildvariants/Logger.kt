package github.nisrulz.example.buildvariants

import android.util.Log

object Logger {
    private const val LOGTAG = ">> FreeBuild---------->"

    fun logd(message: String = "") {
        Log.d(LOGTAG, message)
    }

    fun loge(ex: Exception?) {
        Log.d(LOGTAG, "Exception", ex)
    }
}