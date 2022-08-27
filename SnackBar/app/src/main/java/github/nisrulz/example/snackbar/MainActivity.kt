package github.nisrulz.example.snackbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import github.nisrulz.example.snackbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            button.setOnClickListener { view ->
                Snackbar.make(
                    view,
                    "This is a snackbar!",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }
}