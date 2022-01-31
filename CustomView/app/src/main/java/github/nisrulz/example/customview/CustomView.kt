package github.nisrulz.example.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var paint = Paint()
    private var _txt = "Custom Text"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        setBackgroundColor(Color.BLUE)
        canvas.drawText(_txt, 100f, 250f, paint)
    }

    fun setText(txt: String) {
        _txt = txt
        invalidate()
    }

    init {
        paint.apply {
            color = Color.WHITE
            textSize = 150f
        }
    }
}