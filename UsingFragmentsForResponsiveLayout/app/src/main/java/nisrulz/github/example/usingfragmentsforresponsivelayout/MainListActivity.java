package nisrulz.github.example.usingfragmentsforresponsivelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

public class MainListActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_list);

    ArrayList<String> datalist = new ArrayList<>();
    datalist.add("Apples");
    datalist.add("Oranges");
    datalist.add("Peaches");
    
    MasterListFragment masterListFragment = new MasterListFragment();
    masterListFragment.setDatalist(datalist);

    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_masterlist_placeholder, masterListFragment)
        .commit();
  }
}
