package github.nisrulz.example.usingpocketsphinxforvoicerecognition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import edu.cmu.pocketsphinx.Assets
import github.nisrulz.example.usingpocketsphinxforvoicerecognition.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val speechRecognizerManager: SpeechRecognizerManager
            by lazy {
                val hotWord = resources.getString(R.string.hotword)
                val assets = Assets(this)
                SpeechRecognizerManager(assets, hotWord, onResultListener)
            }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            speechRecognizerManager.init()
        }
    }

    private val onResultListener = object : OnResultListener {
        override fun onResult(commands: ArrayList<String>?) {
            val firstCommand = commands?.first()
            firstCommand.let {
                val color = when (it) {
                    "red" -> R.color.red
                    "blue" -> R.color.blue
                    "green" -> R.color.green
                    else -> R.color.white
                }
                changeBackgroundColor(binding, color)
            }
        }
    }

    private fun changeBackgroundColor(binding: ActivityMainBinding, color: Int) {
        binding.rootview.setBackgroundColor(ContextCompat.getColor(this, color))

    }

    override fun onDestroy() {
        super.onDestroy()
        speechRecognizerManager.destroy()
    }
}