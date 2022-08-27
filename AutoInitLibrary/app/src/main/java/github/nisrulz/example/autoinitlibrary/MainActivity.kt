package github.nisrulz.example.autoinitlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.awesomelib.AwesomeLib
import github.nisrulz.example.autoinitlibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            // No need to init the Library anymore, as it is being done so on app start

            // Set the textview
            textView.text = AwesomeLib.stringData
        }


    }
}
