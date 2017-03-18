package nisrulz.github.sample.usingopennlp.opennlp;

import android.app.Activity;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import nisrulz.github.sample.usingopennlp.R;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class SentenceDetector {
  public String[] findSentences(Activity activity, String data) {
    System.out.println("\n>> Running " + getClass().getSimpleName() + "\n");

    InputStream is = null;
    try {

      is = activity.getResources().openRawResource(R.raw.en_sent);

      if (is != null) {
        SentenceModel model = new SentenceModel(is);
        is.close();
        is = null;
        SentenceDetectorME sdetector = new SentenceDetectorME(model);
        String sentences[] = sdetector.sentDetect(data);
        return sentences;
      }
      else {
        Log.i("TAG", "findSentences: NULL");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return new String[] {};
  }
}