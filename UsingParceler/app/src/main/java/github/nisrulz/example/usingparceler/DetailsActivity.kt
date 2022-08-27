package github.nisrulz.example.usingparceler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.usingparceler.databinding.ActivityDetailsBinding
import org.parceler.Parcels

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            // Use utility function Parcels#unwrap() to convert from parcelable to java bean
            val person = Parcels.unwrap<Person>(
                intent.extras?.getParcelable(getString(R.string.person_detail_key))
            )
            txtView.text = person.toString()
        }
    }
}