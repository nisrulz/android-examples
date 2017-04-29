package nisrulz.github.example.usingfragmentsforresponsivelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainListActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_list);

    MasterListFragment masterListFragment = new MasterListFragment();
    masterListFragment.setDatalist(DataListUtils.getDatalist());

    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_masterlist_placeholder, masterListFragment)
        .commit();
  }
}
