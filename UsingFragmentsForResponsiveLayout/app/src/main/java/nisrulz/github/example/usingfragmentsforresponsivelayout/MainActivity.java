package nisrulz.github.example.usingfragmentsforresponsivelayout;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    int position = getIntent().getIntExtra("index", 0);

    DetailFragment detailFragment = new DetailFragment();
    detailFragment.setIndex(position);
    detailFragment.setDatalist(DataListUtils.getDatalist());

    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_detail_placeholder, detailFragment)
        .commit();
  }
}
