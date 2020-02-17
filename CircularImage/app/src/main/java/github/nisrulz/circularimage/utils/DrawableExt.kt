package github.nisrulz.circularimage.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory

fun Drawable?.clipCircular(context: Context): Drawable? {
    val bmp = this?.convertToBitmap()
    bmp?.let {
        val drawable = RoundedBitmapDrawableFactory.create(context.resources, it.centerCrop())
        drawable.setAntiAlias(true)
        drawable.isCircular = true
        return drawable
    }
    return null
}

fun Drawable.convertToBitmap(): Bitmap {
    if (this is BitmapDrawable)
        return this.bitmap

    val w = if (this.intrinsicWidth <= 0) 1 else this.intrinsicWidth
    val h = if (this.intrinsicHeight <= 0) 1 else this.intrinsicHeight
    val bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    this.setBounds(0, 0, canvas.width, canvas.height)
    this.draw(canvas)
    return bitmap
}

fun Bitmap.centerCrop(): Bitmap {
    return if (width >= height) {
        Bitmap.createBitmap(
            this,
            width / 2 - height / 2,
            0,
            height,
            height
        )
    } else {
        Bitmap.createBitmap(
            this,
            0,
            height / 2 - width / 2,
            width,
            width
        )
    }
}