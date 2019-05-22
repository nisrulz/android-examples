package nisrulz.github.example.usingfragmentsforresponsivelayout;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class DetailFragment extends Fragment {

  private List<String> datalist;
  private int index;

  public DetailFragment() {
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_detail_layout, container, false);

    final TextView textView = (TextView) rootView.findViewById(R.id.textView);
    if (datalist != null) {
      textView.setText(":Selected:\n" + datalist.get(index));
    }else{
      Toast.makeText(getContext(), "Datalist not set!", Toast.LENGTH_SHORT).show();
    }
    return rootView;
  }

  public void setDatalist(List<String> datalist) {
    this.datalist = datalist;
  }

  public void setIndex(int index) {
    this.index = index;
  }
}
