package github.nisrulz.example.webviewdialoguebox

import android.app.Dialog
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.webviewdialoguebox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            fab.setOnClickListener {
                setupDialog()
            }
        }
    }

    private fun setupDialog() = Dialog(this).apply {
        setContentView(R.layout.dialogue_custom)
        val txt = findViewById<TextView>(R.id.textView)
        txt.text = "Text in TextView"
        val webView = findViewById<WebView>(R.id.webView)
        val htmlData = """<html>
                          <body style='background:black;color:white;padding:2em;'>
                          I am the WebView inside the Custom Dialog
                          </body>
                          </html>"""
        webView.loadData(htmlData, "text/html", "utf-8")
        val btnOk = findViewById<Button>(R.id.btnDialogOk)
        btnOk.setOnClickListener { dismiss() }
        show()
    }
}