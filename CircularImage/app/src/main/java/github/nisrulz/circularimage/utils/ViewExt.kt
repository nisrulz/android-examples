package github.nisrulz.circularimage

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun View?.clipToCircle() {
    this?.apply {
        clipToOutline = true
        // Set to null to disable shadows
        outlineProvider = CircularOutlineProvider
    }
}