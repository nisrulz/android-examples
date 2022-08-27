package github.nisrulz.example.implementingemoticons

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.implementingemoticons.databinding.ActivityMainBinding
import hani.momanii.supernova_emoji_library.Actions.EmojIconActions
import hani.momanii.supernova_emoji_library.Actions.EmojIconActions.KeyboardListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            setupUi(this)
        }
    }

    private fun setupUi(binding: ActivityMainBinding) {
        with(binding) {
            val emojIcon = EmojIconActions(
                applicationContext, rootView,
                emojiconEditText, emojiBtn
            )
            emojIcon.ShowEmojIcon()
            emojIcon.setKeyboardListener(object : KeyboardListener {
                override fun onKeyboardOpen() {
                    Log.e("Keyboard", "open")
                }

                override fun onKeyboardClose() {
                    Log.e("Keyboard", "close")
                }
            })
            useSystemDefaultCheckbox.setOnCheckedChangeListener { _, value ->
                emojIcon.setUseSystemEmoji(value)
                textView.setUseSystemDefault(value)
            }
            submitBtn.setOnClickListener {
                val newText = emojiconEditText.text.toString()
                textView.text = newText
            }
        }

    }
}