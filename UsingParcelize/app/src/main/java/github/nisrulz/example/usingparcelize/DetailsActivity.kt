package github.nisrulz.example.usingparcelize

import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.usingparcelize.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            val person = getPersonDataFromIntent()
            txtView.text = "Received Data from First Activity \n\n$person"
        }
    }

    private fun getPersonDataFromIntent(): Person {
        return (intent.extras
            ?.getParcelable<Parcelable>(getString(R.string.person_detail_key)) as Person?)
            ?: Person()
    }
}
