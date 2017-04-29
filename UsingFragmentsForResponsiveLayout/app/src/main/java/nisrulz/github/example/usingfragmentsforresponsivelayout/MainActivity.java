package nisrulz.github.example.usingfragmentsforresponsivelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ArrayList<String> datalist = new ArrayList<>();
    datalist.add("Apples");
    datalist.add("Oranges");
    datalist.add("Peaches");

    DetailFragment detailFragment = new DetailFragment();
    detailFragment.setIndex(0);
    detailFragment.setDatalist(datalist);

    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_detail_placeholder, detailFragment)
        .commit();
  }
}
