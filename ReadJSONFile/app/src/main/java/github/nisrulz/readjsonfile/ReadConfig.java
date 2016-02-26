package github.nisrulz.readjsonfile;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Nishant Srivastava
 * @project ReadJSONFile
 * @company Excogitation
 * @package github.nisrulz.readjsonfile
 * @date 26/Feb/2016
 */
public class ReadConfig {

    public JSONObject loadJSONFromAsset(Context context, String filename) {
        String json = null;
        JSONObject jsonObject = null;
        try {

            InputStream is = context.getAssets().open(filename);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;

    }

}
