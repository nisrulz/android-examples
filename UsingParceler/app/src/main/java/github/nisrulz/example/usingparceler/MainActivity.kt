package github.nisrulz.example.usingparceler

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.usingparceler.databinding.ActivityMainBinding
import org.parceler.Parcels

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            val person = Person(
                name = "John",
                age = 28,
                address = "USA",
                occupation = "Software Developer"
            )
            txtView.text = person.toString()
            fab.setOnClickListener {
                startDetailsActivity(person)
            }
        }
    }

    private fun startDetailsActivity(person: Person) {
        val intent = Intent(this, DetailsActivity::class.java)
        // Use utility function Parcels#wrap() to convert to parcelable
        intent.putExtra(getString(R.string.person_detail_key), Parcels.wrap(person))
        startActivity(intent)
        finish()
    }
}