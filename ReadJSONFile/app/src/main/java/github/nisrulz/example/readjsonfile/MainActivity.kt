package github.nisrulz.example.readjsonfile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.readjsonfile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val configJson by lazy { ReadConfig().loadJSONFromAsset(this, "config.json") }

    private val str = "Text Loaded from config.json\n\n"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

            val text = configJson?.let {
                val name = it.getString("name")
                val text = it.getString("text")
                val txt = "\nName : $name\n\nText :$text"
                txt
            } ?: "Error"

            binding.textView.text = "$str $text"
        }
    }
}