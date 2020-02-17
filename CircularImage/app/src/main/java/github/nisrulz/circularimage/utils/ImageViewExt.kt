package github.nisrulz.circularimage.utils

import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun ImageView.setDrawableAsCircular(drawable: Drawable?) {
    drawable?.let {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.setImageDrawable(drawable)
            this.clipToCircle()
        } else {
            this.setImageDrawable(drawable.clipCircular(this.context))
        }
    }
}

fun ImageView.setDrawableAsCircular(@DrawableRes drawableRes: Int) {
    val drawable = ContextCompat.getDrawable(this.context, drawableRes)
    this.setDrawableAsCircular(drawable)
}