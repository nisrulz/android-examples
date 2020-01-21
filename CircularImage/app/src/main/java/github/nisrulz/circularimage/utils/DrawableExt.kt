package github.nisrulz.circularimage

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory


fun Drawable?.circular(context: Context): Drawable? {
    val bmp = this?.convertDrawableToBitmap()
    bmp?.let {
        val drawable = RoundedBitmapDrawableFactory.create(context.resources, it)
        drawable.setAntiAlias(true)
        drawable.isCircular = true
        return drawable
    }
    return null
}

fun Drawable.convertDrawableToBitmap(): Bitmap {
    if (this is BitmapDrawable)
        return this.bitmap
    val bounds = this.bounds
    val width = if (!bounds.isEmpty) bounds.width() else this.intrinsicWidth
    val height = if (!bounds.isEmpty) bounds.height() else this.intrinsicHeight
    // Now we check we are > 0
    val bitmap = Bitmap.createBitmap(
        if (width <= 0) 1 else width, if (height <= 0) 1 else height,
        Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    this.setBounds(0, 0, canvas.width, canvas.height)
    this.draw(canvas)
    return bitmap
}