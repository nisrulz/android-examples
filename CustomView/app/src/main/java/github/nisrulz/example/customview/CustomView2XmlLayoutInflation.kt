package github.nisrulz.example.customview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.withStyledAttributes

class CustomView2XmlLayoutInflation @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val view by lazy { inflate(context, R.layout.custom_view_2, this) }

    private lateinit var title: TextView
    private lateinit var subtitle: TextView

    init {
        // Init Views
        view?.apply {
            title = findViewById(R.id.title)
            subtitle = findViewById(R.id.subtitle)
        }

        // Apply data to views
        context.withStyledAttributes(attrs, R.styleable.custom_view_2) {
            val titleStr = getString(R.styleable.custom_view_2_title) ?: ""
            setTitle(titleStr)
            val subtitleStr = getString(R.styleable.custom_view_2_subtitle) ?: ""
            setSubTitle(subtitleStr)

            val bgColor = getColor(R.styleable.custom_view_2_bgColor, Color.BLACK)
            setBackgroundColor(bgColor)

            val txtColor = getColor(R.styleable.custom_view_2_txtColor, Color.WHITE)
            val txtSize = getDimension(R.styleable.custom_view_2_txtSize, 8f)
            title.apply {
                setTextColor(txtColor)
                textSize = txtSize
            }

            subtitle.apply {
                setTextColor(txtColor)
                textSize = txtSize
            }
        }


    }

    fun setTitle(str: String) {
        title.text = str
    }

    fun setSubTitle(str: String) {
        subtitle.text = str
    }
}