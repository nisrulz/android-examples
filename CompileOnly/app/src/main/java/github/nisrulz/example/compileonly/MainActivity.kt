package github.nisrulz.example.compileonly

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.awesomelib.AwesomeLibMain
import github.nisrulz.example.compileonly.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

            // Create an instance of AwesomeLib
            val awesomeLibMain = AwesomeLibMain()

            // Use the init() method to get the boolean value for is Retrofit on Classpath
            val hasRetrofitOnClasspath = awesomeLibMain.init()
            textView.text = "isRetrofitAvailable in Classpath: $hasRetrofitOnClasspath"
        }
    }
}