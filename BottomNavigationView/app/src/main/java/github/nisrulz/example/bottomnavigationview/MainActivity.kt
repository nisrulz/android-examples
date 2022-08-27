package github.nisrulz.example.bottomnavigationview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.bottomnavigationview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            bottomNavigationView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.update_item -> textView.text = "Update Item Selected"
                    R.id.location_item -> textView.text = "Location Item Selected"
                    R.id.favorite_item -> textView.text = "Favorite Item Selected"
                }
                true
            }

        }
    }
}