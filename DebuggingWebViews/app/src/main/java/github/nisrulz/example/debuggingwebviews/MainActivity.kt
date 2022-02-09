package github.nisrulz.example.debuggingwebviews

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.debuggingwebviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            enableWebViewDebugging()
            loadHtmlInsideWebView(this)
        }
    }


    private fun enableWebViewDebugging() {
        WebView.setWebContentsDebuggingEnabled(true)
    }

    private fun loadHtmlInsideWebView(binding: ActivityMainBinding) {
        val htmlAsFormattedString = """ <!DOCTYPE html>
                                        <html>
                                        <body onload="myFunction()">
                                          Check developer web console
                                          <script>
                                            function myFunction(){
                                              console.log("I am printed in the developer web console")
                                          }
                                          </script>
                                        </body>
                                        </html>"""
        binding.webview.loadData(htmlAsFormattedString, "text/html", "UTF-8")
    }
}
