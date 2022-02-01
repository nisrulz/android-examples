package github.nisrulz.example.customview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class CustomView2XmlLayoutInflation @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var title: TextView
    private lateinit var subtitle: TextView

    init {
        val view = inflate(context, R.layout.custom_view_2, this)
        view?.apply {
            title = findViewById(R.id.title)
            subtitle = findViewById(R.id.subtitle)
            setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
        }
    }

    fun setTitle(str: String) {
        title.apply {
            text = str
            setTextColor(Color.WHITE)
        }
    }

    fun setSubTitle(str: String) {
        subtitle.apply {
            text = str
            setTextColor(Color.WHITE)
        }
    }
}