package github.nisrulz.collapsibletoolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.collapsibletoolbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            setSupportActionBar(toolbar)

            collapsingToolbarLayout.title = "Animated Toolbar"
            textv1.text = resources.getString(R.string.dummytext)
        }
    }
}