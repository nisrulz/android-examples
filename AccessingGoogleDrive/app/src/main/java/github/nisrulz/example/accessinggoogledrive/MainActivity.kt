package github.nisrulz.example.accessinggoogledrive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.accessinggoogledrive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
        }
    }
}