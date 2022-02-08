package github.nisrulz.example.usingprocesslifecycleownerforlibs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.usingprocesslifecycleownerforlibs.databinding.ActivityMain2Binding

class Main2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            txt2.setOnClickListener {
                startActivity(
                    Intent(
                        this@Main2Activity,
                        MainActivity::class.java
                    )
                )
            }
        }
    }
}