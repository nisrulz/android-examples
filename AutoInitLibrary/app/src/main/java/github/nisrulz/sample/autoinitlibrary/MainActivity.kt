package github.nisrulz.sample.autoinitlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.sample.awesomelib.AwesomeLib
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get Instance
        val awesomeLib = AwesomeLib.getInstance()

        // No need to init the Library anymore, as it is being done so on app start

        // Set the textview
        textView.text = awesomeLib.stringData
    }
}
