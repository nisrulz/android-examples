package github.nisrulz.example.usingprocesslifecycleownerforlibs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.usingprocesslifecycleownerforlibs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            txt1.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        Main2Activity::class.java
                    )
                )
            }
        }
    }
}