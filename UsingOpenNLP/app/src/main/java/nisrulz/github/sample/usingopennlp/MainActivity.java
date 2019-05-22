package nisrulz.github.sample.usingopennlp;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import nisrulz.github.sample.usingopennlp.opennlp.NamedEntityExtraction;
import nisrulz.github.sample.usingopennlp.opennlp.SentenceDetector;

public class MainActivity extends AppCompatActivity {

  private EditText editText;
  private TextView textView;
  private Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initView();
  }

  private void initView() {
    editText = (EditText) findViewById(R.id.editText);
    textView = (TextView) findViewById(R.id.textView);
    button = (Button) findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (!TextUtils.isEmpty(editText.getText().toString())) {
          button.setEnabled(false);
          button.setText("Processing...");
          Activity activity = MainActivity.this;
          String text = editText.getText().toString();
          StringBuilder stringBuilder = new StringBuilder().append("Sentences:\n")
              .append(getSentencesFromParagraph(activity, text))
              .append("\n\nNames:\n")
              .append(getNamesFromParagraph(activity, text))
              .append("\n\nLocations:\n")
              .append(getLocationFromParagraph(activity, text));
          textView.setText(stringBuilder.toString());
          button.setText("Run Analysis");
          button.setEnabled(true);
        }
      }
    });
  }

  private String generateString(String[] values) {
    String finalData = "";
    for (int i = 0; i < values.length; i++) {
      finalData += values[i] + "\n";
    }

    return finalData;
  }

  private String getSentencesFromParagraph(Activity activity, String paragraph) {
    String[] sentences = new SentenceDetector().findSentences(activity, paragraph);
    return generateString(sentences);
  }

  private String getNamesFromParagraph(Activity activity, String paragraph) {
    String[] names =
        new NamedEntityExtraction().findNames(activity, paragraph, R.raw.en_ner_person);
    return generateString(names);
  }

  private String getLocationFromParagraph(Activity activity, String paragraph) {
    String[] locations =
        new NamedEntityExtraction().findNames(activity, paragraph, R.raw.en_ner_location);
    return generateString(locations);
  }
}
