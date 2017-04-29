package nisrulz.github.example.usingfragmentsforresponsivelayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

public class MasterListFragment extends Fragment {

  private List<String> datalist;

  public MasterListFragment() {
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_masterlist_layout, container, false);

    final ListView listView = (ListView) rootView.findViewById(R.id.listview);
    if (datalist != null) {
      ArrayAdapter<String> adapter =
          new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, datalist);
      listView.setAdapter(adapter);
    }
    else {
      Toast.makeText(getContext(), "Datalist not set!", Toast.LENGTH_SHORT).show();
    }
    return rootView;
  }

  public void setDatalist(List<String> datalist) {
    this.datalist = datalist;
  }
}
