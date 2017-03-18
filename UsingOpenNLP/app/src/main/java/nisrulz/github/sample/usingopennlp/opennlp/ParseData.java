package nisrulz.github.sample.usingopennlp.opennlp;

import android.app.Activity;
import java.io.IOException;
import java.io.InputStream;
import nisrulz.github.sample.usingopennlp.R;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.parser.chunking.Parser;

public class ParseData {

  public void parse(Activity activity, String data) {
    System.out.println("\n>> Running " + getClass().getSimpleName() + "\n");

    // http://sourceforge.net/apps/mediawiki/opennlp/index.php?title=Parser#Training_Tool
    InputStream is = activity.getResources().openRawResource(R.raw.en_parser_chunking);
    try {
      ParserModel model = new ParserModel(is);
      Parser parser = (Parser) ParserFactory.create(model);
      Parse topParses[] = ParserTool.parseLine(data, parser, 1);
      for (Parse p : topParses)
        p.show();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
