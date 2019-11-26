package github.nisrulz.usingparcelize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val person = intent.extras?.getParcelable<Parcelable>(getString(R.string.person_detail_key)) as Person?
        person?.let {
            Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
