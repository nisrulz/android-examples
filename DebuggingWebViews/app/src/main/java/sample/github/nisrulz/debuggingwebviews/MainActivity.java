package sample.github.nisrulz.debuggingwebviews;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Enable webview debugging
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      WebView.setWebContentsDebuggingEnabled(true);
    }

    WebView webView=(WebView)findViewById(R.id.webview);

    String html_string="<!DOCTYPE html>\n"
        + "<html>\n"
        + "<body onload=\"myFunction()\">\n"
        + "  Hello World!\n"
        + "  <script>\n"
        + "    function myFunction(){\n"
        + "      console.log(\"I am printed in the console\")\n"
        + "  }\n"
        + "  </script>\n"
        + "</body>\n"
        + "</html>";


    webView.loadData(html_string,"text/html","UTF-8");
  }
}
