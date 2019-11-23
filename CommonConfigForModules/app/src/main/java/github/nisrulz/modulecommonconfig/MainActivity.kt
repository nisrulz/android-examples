package github.nisrulz.modulecommonconfig

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.androidlib.AndroidLib
import github.nisrulz.androidlib2.AndroidLib2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayStr = "String loaded from ${AndroidLib.nameOfModule}\nString loaded from ${AndroidLib2.nameOfModule}\n"
        txt.text = displayStr
    }
}
