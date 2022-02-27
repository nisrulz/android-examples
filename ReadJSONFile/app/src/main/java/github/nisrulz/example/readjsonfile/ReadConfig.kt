package github.nisrulz.example.readjsonfile

import android.content.Context
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import kotlin.text.Charsets.UTF_8

class ReadConfig {
    fun loadJSONFromAsset(context: Context, filename: String?): JSONObject? {
        var jsonObject: JSONObject? = null
        val json = try {
            val inputStream = context.assets.open(filename!!)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        try {
            jsonObject = JSONObject(json)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return jsonObject
    }
}