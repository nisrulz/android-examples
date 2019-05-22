package github.nisrulz.example.usingpocketsphinxforvoicerecognition;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rootview;
    private SpeechRecognizerManager mSpeechRecognizerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rootview = (RelativeLayout) findViewById(R.id.rootview);
        mSpeechRecognizerManager = new SpeechRecognizerManager(this);
        mSpeechRecognizerManager.setOnResultListener(new SpeechRecognizerManager.OnResultListener() {
            @Override
            public void OnResult(ArrayList<String> commands) {

                if (commands.get(0).equals("red")) {
                    changeBackgroundColor(R.color.red);
                } else if (commands.get(0).equals("blue")) {
                    changeBackgroundColor(R.color.blue);
                } else if (commands.get(0).equals("green")) {
                    changeBackgroundColor(R.color.green);
                }
            }
        });
    }

    private void changeBackgroundColor(int color) {
        if (rootview != null) {
            rootview.setBackgroundColor(ContextCompat.getColor(this, color));
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSpeechRecognizerManager.destroy();
    }
}
