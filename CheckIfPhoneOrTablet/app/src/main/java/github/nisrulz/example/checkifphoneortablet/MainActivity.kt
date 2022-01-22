package github.nisrulz.example.checkifphoneortablet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.checkifphoneortablet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

            val tabletSize = resources.getBoolean(R.bool.isTablet)

            if (tabletSize) {
                // Is Tablet
                textView.text = "TABLET"
            } else {
                // Is Phone
                textView.text = "PHONE"
            }
        }
    }
}