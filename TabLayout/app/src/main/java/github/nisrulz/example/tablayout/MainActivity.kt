package github.nisrulz.example.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.tablayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            setSupportActionBar(toolbar)

            tabLayout.apply {
                addTab(newTab().setText("Tab One"))
                addTab(newTab().setText("Tab Two"))
                addTab(newTab().setText("Tab Three"))
            }
        }
    }
}