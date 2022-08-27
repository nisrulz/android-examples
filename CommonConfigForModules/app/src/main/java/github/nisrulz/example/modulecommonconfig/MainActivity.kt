package github.nisrulz.example.modulecommonconfig

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.androidlib.AndroidLib
import github.nisrulz.example.androidlib2.AndroidLib2
import github.nisrulz.example.modulecommonconfig.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            val displayStr = "String loaded from " +
                        AndroidLib.nameOfModule +
                        "\nString loaded from " +
                        AndroidLib2.nameOfModule +
                        "\n"
            txt.text = displayStr
        }
    }
}
