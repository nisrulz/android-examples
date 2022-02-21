package github.nisrulz.example.usingfontawesomelib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.usingfontawesomelib.FontManager.getTypeface
import github.nisrulz.example.usingfontawesomelib.FontManager.markAsIconContainer
import github.nisrulz.example.usingfontawesomelib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            setupUi(this)
        }
    }

    private fun setupUi(binding: ActivityMainBinding) {
        binding.apply {

            // Iterate over all textview under the linear layout and apply the font awesome font to them
            val iconFont = getTypeface(
                applicationContext, FontManager.font_awesome_webfont_file
            )
            markAsIconContainer(iconsContainer, iconFont)

            // Apply the font awesome to a single textview
            singleTextview.typeface = iconFont

            // Apply the font awesome to a single button
            singleButton.typeface = iconFont
        }
    }
}