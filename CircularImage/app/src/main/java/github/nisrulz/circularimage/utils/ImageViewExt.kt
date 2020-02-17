package github.nisrulz.circularimage.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun ImageView.setDrawableAsCircular(context: Context, drawable: Drawable?) {
    drawable?.let {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.setImageDrawable(drawable)
            this.clipToCircle()
        } else {
            this.setImageDrawable(drawable.clipCircular(context))
        }
    }
}

fun ImageView.setDrawableAsCircular(context: Context, @DrawableRes drawableRes: Int) {
    val drawable = ContextCompat.getDrawable(context, drawableRes)
    this.setDrawableAsCircular(context, drawable)
}