package sample.github.nisrulz.debuggingwebviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

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
