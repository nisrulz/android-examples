package github.nisrulz.example.usingfontawesomelib

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

object FontManager {
    const val font_awesome_webfont_file = "fonts/fontawesome-webfont.ttf"

    @JvmStatic
    fun getTypeface(context: Context, font: String): Typeface {
        return Typeface.createFromAsset(context.assets, font)
    }

    @JvmStatic
    fun markAsIconContainer(v: View, typeface: Typeface) {
        when (v) {
            is ViewGroup -> {
                for (i in 0 until v.childCount) {
                    val child = v.getChildAt(i)
                    markAsIconContainer(child, typeface)
                }
            }
            is TextView -> {
                v.typeface = typeface
            }
        }
    }
}