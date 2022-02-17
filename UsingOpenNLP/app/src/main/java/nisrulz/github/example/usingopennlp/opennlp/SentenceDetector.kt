package nisrulz.github.example.usingopennlp.opennlp

import android.app.Activity
import nisrulz.github.example.usingopennlp.R
import opennlp.tools.sentdetect.SentenceDetectorME
import opennlp.tools.sentdetect.SentenceModel
import java.io.IOException
import java.io.InputStream

class SentenceDetector {
    fun findSentences(activity: Activity, data: String?): Array<String> {
        println(
            """
    
    >> Running ${javaClass.simpleName}
    
    """.trimIndent()
        )
        var inputStream: InputStream? = null
        try {
            inputStream = activity.resources.openRawResource(R.raw.en_sent)
            val model = SentenceModel(inputStream)
            inputStream.close()
            inputStream = null
            val sdetector = SentenceDetectorME(model)
            return sdetector.sentDetect(data)
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
        return arrayOf()
    }
}