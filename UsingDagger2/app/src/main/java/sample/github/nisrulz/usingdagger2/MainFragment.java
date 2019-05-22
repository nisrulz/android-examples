package sample.github.nisrulz.usingdagger2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainView {

  @Inject MainPresenter presenter;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(this);
  }

  public MainFragment() {
    // Required empty public constructor
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_main, container, false);
  }
}
