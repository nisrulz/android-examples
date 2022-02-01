package github.nisrulz.example.customview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import github.nisrulz.example.customview.databinding.CustomView2Binding

class CustomView2ViewBinding @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var binding = CustomView2Binding
        .inflate(LayoutInflater.from(context), this, true)

    private val view = binding.root

    init {
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
    }

    fun setTitle(str: String) {
        binding.title.apply {
            text = str
            setTextColor(Color.WHITE)
        }
    }

    fun setSubTitle(str: String) {
        binding.subtitle.apply {
            text = str
            setTextColor(Color.WHITE)
        }
    }
}