package github.nisrulz.example.vectordrawables

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.vectordrawables.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

            // Programmatically loading vector drawable
            imgvw.setImageResource(R.drawable.ic_adb_black_24dp)
        }
    }
}