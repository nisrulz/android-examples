package nisrulz.github.sample.usingopennlp.opennlp;

import android.app.Activity;
import java.io.IOException;
import java.io.InputStream;
import nisrulz.github.sample.usingopennlp.R;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class TokenExtraction {

  public String[] extract(Activity activity, String data) {
    System.out.println("\n>> Running " + getClass().getSimpleName() + "\n");

    InputStream is = activity.getResources().openRawResource(R.raw.en_token);

    TokenizerModel model = null;
    String[] tokens = null;
    try {
      model = new TokenizerModel(is);
      TokenizerME tokenizer = new TokenizerME(model);

      tokens = tokenizer.tokenize(data);
      for (int i = 0; i < tokens.length; i++) {
        System.out.println(tokens[i]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return tokens;
  }
}
