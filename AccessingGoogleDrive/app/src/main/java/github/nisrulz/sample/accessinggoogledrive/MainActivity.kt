package github.nisrulz.sample.accessinggoogledrive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.sample.accessinggoogledrive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }
    }
}