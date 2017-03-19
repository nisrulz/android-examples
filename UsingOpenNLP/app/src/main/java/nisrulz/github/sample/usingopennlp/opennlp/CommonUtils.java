package nisrulz.github.sample.usingopennlp.opennlp;

import opennlp.tools.tokenize.WhitespaceTokenizer;

public class CommonUtils {

	public String[] createTokensFromString(String sentence) {
		WhitespaceTokenizer whitespaceTokenizer = WhitespaceTokenizer.INSTANCE;
		String[] tokens = whitespaceTokenizer.tokenize(sentence);
		return tokens;
	}
}
