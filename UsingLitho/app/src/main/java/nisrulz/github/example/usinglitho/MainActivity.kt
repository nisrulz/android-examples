package nisrulz.github.example.usinglitho

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.widget.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val componentContext = ComponentContext(this)
        val textView = createLithoTextView(componentContext)
        setContentView(textView)
    }

    private fun createLithoTextView(componentContext: ComponentContext): LithoView? {
        val textComponent = Text.create(componentContext)
            .text("Hello World!")
            .textColor(Color.BLUE)
            .textSizeDip(40f)
            .textStyle(Typeface.BOLD)
            .build()

        return LithoView.create(componentContext, textComponent)
    }
}