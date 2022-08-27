package github.nisrulz.example.customview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            myCustomView1.setText("Hello World!")
            myCustomView2.apply {
                setTitle("Android")
                setSubTitle("Oreo")
            }

            myCustomView3.apply {
                // setTitle("Android")
                // setSubTitle("Kitkat")
            }
        }
    }
}