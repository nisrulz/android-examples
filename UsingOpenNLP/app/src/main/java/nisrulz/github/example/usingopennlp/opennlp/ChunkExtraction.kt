package nisrulz.github.example.usingopennlp.opennlp

import android.app.Activity
import nisrulz.github.example.usingopennlp.R
import opennlp.tools.chunker.ChunkerME
import opennlp.tools.chunker.ChunkerModel
import opennlp.tools.cmdline.postag.POSModelLoader
import opennlp.tools.postag.POSTaggerME
import opennlp.tools.tokenize.WhitespaceTokenizer
import java.io.File
import java.io.IOException
import java.io.InputStream

class ChunkExtraction {
    fun getChunks(activity: Activity, data: String?) {
        println(
            """
    
    >> Running ${javaClass.simpleName}
    
    """.trimIndent()
        )
        var inputStream: InputStream? = null
        var model: ChunkerModel? = null

        // Loading the chunker model
        try {
            inputStream = activity.resources.openRawResource(R.raw.en_chunker)
            model = ChunkerModel(inputStream)
        } catch (e: IOException) {
            // Model loading failed, handle the error
            e.printStackTrace()
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close()
                } catch (e: IOException) {
                }
            }
        }

        // Instantiate the ChunkerME class
        val chunker = ChunkerME(model)
        val tokens = createTokensFromString(data)
        val pos = getPOSTags(tokens)
        val span = chunker.chunkAsSpans(tokens, pos)
        for (s in span) {
            println(s.toString())
            for (i in s.start until s.end) {
                println(tokens[i].toString() + " ")
            }
        }
    }

    fun getPOSTags(tokens: Array<String>?): Array<String> {
        // Generating the POS tags
        val file = File("./models/en-pos-maxent.bin")
        val model = POSModelLoader().load(file)
        // Constructing the tagger
        val tagger = POSTaggerME(model)
        // Generating tags from the tokens
        return tagger.tag(tokens)
    }
}

fun createTokensFromString(sentence: String?): Array<String> {
    val whitespaceTokenizer = WhitespaceTokenizer.INSTANCE
    return whitespaceTokenizer.tokenize(sentence)
}