package github.nisrulz.sample.usingparceler;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import org.parceler.Parcels;

public class DetailsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details);

    // Use utility function Parcels#unwrap() to convert from parceable to java bean
    Person person = Parcels.unwrap(
        getIntent().getExtras().getParcelable(getString(R.string.person_detail_key)));

    Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();
  }
}
