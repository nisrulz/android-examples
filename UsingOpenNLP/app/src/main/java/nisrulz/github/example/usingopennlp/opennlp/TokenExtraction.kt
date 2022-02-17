package nisrulz.github.example.usingopennlp.opennlp

import android.app.Activity
import nisrulz.github.example.usingopennlp.R
import opennlp.tools.tokenize.TokenizerME
import opennlp.tools.tokenize.TokenizerModel
import java.io.IOException

class TokenExtraction {
    fun extract(activity: Activity, data: String?): Array<String?>? {
        println(
            """
    
    >> Running ${javaClass.simpleName}
    
    """.trimIndent()
        )
        val inputStream = activity.resources.openRawResource(R.raw.en_token)
        var tokens: Array<String?>? = null
        try {
            val model = TokenizerModel(inputStream)
            val tokenizer = TokenizerME(model)
            tokens = tokenizer.tokenize(data)
            for (i in tokens.indices) {
                println(tokens[i])
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                inputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return tokens
    }
}