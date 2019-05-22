package github.nisrulz.sample.implementingemoticons;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;
import hani.momanii.supernova_emoji_library.Helper.EmojiconTextView;

public class MainActivity extends AppCompatActivity {

  CheckBox mCheckBox;
  EmojiconEditText emojiconEditText;
  EmojiconTextView textView;
  ImageView emojiButton;
  ImageView submitButton;
  View rootView;
  EmojIconActions emojIcon;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    rootView = findViewById(R.id.root_view);
    emojiButton = (ImageView) findViewById(R.id.emoji_btn);
    submitButton = (ImageView) findViewById(R.id.submit_btn);
    mCheckBox = (CheckBox) findViewById(R.id.use_system_default);
    emojiconEditText = (EmojiconEditText) findViewById(R.id.emojicon_edit_text);
    textView = (EmojiconTextView) findViewById(R.id.textView);
    emojIcon = new EmojIconActions(this, rootView, emojiconEditText, emojiButton);
    emojIcon.ShowEmojIcon();
    emojIcon.setKeyboardListener(new EmojIconActions.KeyboardListener() {
      @Override
      public void onKeyboardOpen() {
        Log.e("Keyboard", "open");
      }

      @Override
      public void onKeyboardClose() {
        Log.e("Keyboard", "close");
      }
    });

    mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        emojIcon.setUseSystemEmoji(b);
        textView.setUseSystemDefault(b);
      }
    });

    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String newText = emojiconEditText.getText().toString();
        textView.setText(newText);
      }
    });
  }
}
