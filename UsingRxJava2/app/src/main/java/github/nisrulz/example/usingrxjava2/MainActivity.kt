package github.nisrulz.example.usingrxjava2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.usingrxjava2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val logTag: String by lazy { this.javaClass.simpleName }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            setupExamples(logTag)
        }
    }
}