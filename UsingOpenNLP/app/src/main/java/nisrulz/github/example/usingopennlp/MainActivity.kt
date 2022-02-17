package nisrulz.github.example.usingopennlp

import android.app.Activity
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import nisrulz.github.example.usingopennlp.databinding.ActivityMainBinding
import nisrulz.github.example.usingopennlp.opennlp.NamedEntityExtraction
import nisrulz.github.example.usingopennlp.opennlp.SentenceDetector

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            initView(this)
        }
    }

    private fun initView(binding: ActivityMainBinding) {
        binding.apply {
            button.setOnClickListener {
                val text = editText.text.toString()
                if (!TextUtils.isEmpty(text)) {
                    button.isEnabled = false
                    button.text = "Processing..."
                    val activity: Activity = this@MainActivity
                    val stringBuilder = StringBuilder().append("Sentences:\n")
                        .append(getSentencesFromParagraph(activity, text))
                        .append("\n\nNames:\n")
                        .append(getNamesFromParagraph(activity, text))
                        .append("\n\nLocations:\n")
                        .append(getLocationFromParagraph(activity, text))
                    textView.text = stringBuilder.toString()
                    button.text = "Run Analysis"
                    button.isEnabled = true
                }
            }
        }

    }

    private fun generateString(values: Array<String>): String {
        var finalData = ""
        for (i in values.indices) {
            finalData += """
                ${values[i]}
                
                """.trimIndent()
        }
        return finalData
    }

    private fun getSentencesFromParagraph(activity: Activity, paragraph: String): String {
        val sentences = SentenceDetector().findSentences(activity, paragraph)
        return generateString(sentences)
    }

    private fun getNamesFromParagraph(activity: Activity, paragraph: String): String {
        val names = NamedEntityExtraction().findNames(activity, paragraph, R.raw.en_ner_person)
        return generateString(names)
    }

    private fun getLocationFromParagraph(activity: Activity, paragraph: String): String {
        val locations =
            NamedEntityExtraction().findNames(activity, paragraph, R.raw.en_ner_location)
        return generateString(locations)
    }
}