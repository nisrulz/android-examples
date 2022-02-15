package github.nisrulz.example.usingparcelize

import android.content.Intent
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.usingparcelize.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

            val person = Person(
                "John",
                "USA",
                25,
                "Software Developer"
            )
            txtView.text = person.toString()
            fab.setOnClickListener {
                sendDataViaIntent(person)
            }
        }
    }

    private fun sendDataViaIntent(person: Person) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(getString(R.string.person_detail_key), person)
        startActivity(intent)
        finish()
    }
}
