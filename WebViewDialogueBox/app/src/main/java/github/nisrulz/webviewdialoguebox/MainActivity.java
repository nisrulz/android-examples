package github.nisrulz.webviewdialoguebox;

import android.app.Dialog;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialogue_custom);
                dialog.setTitle("I am the Title");


                TextView txt = (TextView) dialog.findViewById(R.id.textView);
                txt.setText("Hollaaaaa Hooooman! This is a textview :P");

                WebView webview = (WebView) dialog.findViewById(R.id.webView);

                String htmlData = "<html><body style='background:black;color:white;padding:2em;'>I am the WebView inside the Custom Dialogue :D </body></html>";
                webview.loadData(htmlData.toString(), "text/html", "utf-8");

                Button btn_ok = (Button) dialog.findViewById(R.id.btn_dailogueOK);
                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
}
