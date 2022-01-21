package github.nisrulz.example.builderpattern

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import github.nisrulz.example.builderpattern.User.UserBuilder
import github.nisrulz.example.builderpattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

            val user = UserBuilder("Nishant", "Srivastava")
                .age(24)
                .phone("0000909211")
                .address("my address")
                .build()
            val text = user.firstname + " " + user.lastname

            fab.setOnClickListener { view ->
                Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
            }
        }
    }
}