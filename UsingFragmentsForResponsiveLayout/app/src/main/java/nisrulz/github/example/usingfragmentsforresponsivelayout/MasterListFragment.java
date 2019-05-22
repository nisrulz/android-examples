package nisrulz.github.example.usingfragmentsforresponsivelayout;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

public class MasterListFragment extends Fragment {

  private List<String> datalist;
  private OnItemClickListener callback;

  public MasterListFragment() {
  }

  // Override onAttach to make sure that the container activity has implemented the callback
  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    // This makes sure that the host activity has implemented the callback interface
    // If not, it throws an exception
    try {
      callback = (OnItemClickListener) context;
    } catch (ClassCastException e) {
      throw new ClassCastException(context.toString() + " must implement OnItemClickListener");
    }
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
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
          callback.onItemSelected(i);
        }
      });
    }
    else {
      Toast.makeText(getContext(), "Datalist not set!", Toast.LENGTH_SHORT).show();
    }
    return rootView;
  }

  public void setDatalist(List<String> datalist) {
    this.datalist = datalist;
  }

  interface OnItemClickListener {
    void onItemSelected(int position);
  }
}
