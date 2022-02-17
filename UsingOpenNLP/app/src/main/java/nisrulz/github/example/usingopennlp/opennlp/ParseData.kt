package nisrulz.github.example.usingopennlp.opennlp

import android.app.Activity
import nisrulz.github.example.usingopennlp.R
import opennlp.tools.cmdline.parser.ParserTool
import opennlp.tools.parser.ParserFactory
import opennlp.tools.parser.ParserModel
import opennlp.tools.parser.chunking.Parser
import java.io.IOException

class ParseData {
    fun parse(activity: Activity, data: String?) {
        println(
            """
    
    >> Running ${javaClass.simpleName}
    
    """.trimIndent()
        )

        // http://sourceforge.net/apps/mediawiki/opennlp/index.php?title=Parser#Training_Tool
        val inputStream = activity.resources.openRawResource(R.raw.en_parser_chunking)
        try {
            val model = ParserModel(inputStream)
            val parser = ParserFactory.create(model) as Parser
            val topParses = ParserTool.parseLine(data, parser, 1)
            for (p in topParses) p.show()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                inputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}