package nisrulz.github.sample.usingopennlp.opennlp;

import android.app.Activity;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import nisrulz.github.sample.usingopennlp.R;
import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.util.Span;

public class ChunkExtraction {

  public void getChunks(Activity activity, String data) {
    System.out.println("\n>> Running " + getClass().getSimpleName() + "\n");
    CommonUtils commonUtils = new CommonUtils();

    InputStream is = null;
    ChunkerModel model = null;

    // Loading the chunker model
    try {
      is = activity.getResources().openRawResource(R.raw.en_chunker);
      model = new ChunkerModel(is);
    } catch (IOException e) {
      // Model loading failed, handle the error
      e.printStackTrace();
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
        }
      }
    }

    // Instantiate the ChunkerME class
    ChunkerME chunker = new ChunkerME(model);

    String[] tokens = commonUtils.createTokensFromString(data);
    String pos[] = getPOSTags(tokens);

    Span[] span = chunker.chunkAsSpans(tokens, pos);

    for (Span s : span) {
      System.out.println(s.toString());

      for (int i = s.getStart(); i < s.getEnd(); i++) {
        System.out.println(tokens[i] + " ");
      }
    }
  }

  public String[] getPOSTags(String[] tokens) {
    // Generating the POS tags
    File file = new File("./models/en-pos-maxent.bin");
    POSModel model = new POSModelLoader().load(file);
    // Constructing the tagger
    POSTaggerME tagger = new POSTaggerME(model);
    // Generating tags from the tokens
    String[] tags = tagger.tag(tokens);
    return tags;
  }
}
