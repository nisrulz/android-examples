package github.nisrulz.circularimage.utils

import android.graphics.Outline
import android.os.Build
import android.view.View
import android.view.ViewOutlineProvider
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun View?.clipToCircle() {
    this?.apply {
        clipToOutline = true
        // Set to null to disable shadows
        outlineProvider = CircularOutlineProvider
    }
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
object CircularOutlineProvider : ViewOutlineProvider() {
    override fun getOutline(view: View, outline: Outline) {
        outline.setOval(
            view.paddingLeft,
            view.paddingTop,
            view.width - view.paddingRight,
            view.height - view.paddingBottom
        )
    }
}