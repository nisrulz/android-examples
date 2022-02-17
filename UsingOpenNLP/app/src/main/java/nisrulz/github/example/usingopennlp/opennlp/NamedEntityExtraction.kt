package nisrulz.github.example.usingopennlp.opennlp

import android.app.Activity
import opennlp.tools.namefind.NameFinderME
import opennlp.tools.namefind.TokenNameFinderModel
import java.io.IOException
import java.io.InputStream

class NamedEntityExtraction {
    fun findNames(activity: Activity, data: String?, pathToModel: Int): Array<String> {
        println(
            """
    
    >> Running ${javaClass.simpleName}
    
    """.trimIndent()
        )
        val detectedNames = ArrayList<String>()
        val tokens = createTokensFromString(data)
        var inputStream: InputStream? = null
        try {
            inputStream = activity.resources.openRawResource(pathToModel)
            val model = TokenNameFinderModel(inputStream)
            val detector = NameFinderME(model)
            val nameSpans = detector.find(tokens)
            for (s in nameSpans) {
                val stringBuilder = StringBuilder()
                for (i in s.start until s.end) {
                    stringBuilder.append(tokens[i])
                }
                detectedNames.add(stringBuilder.toString())
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return detectedNames.toTypedArray()
    }
}