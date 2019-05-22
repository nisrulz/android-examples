package github.nisrulz.headlessfragment;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class HeadlessFragment extends Fragment {

    public static final String TAG = "headless_fragment";

    public HeadlessFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Because its a headless fragment
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Persist between configuration changes
        setRetainInstance(true);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        executeInHeadlessFragment();

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void executeInHeadlessFragment() {
        Toast.makeText(getContext(), "Called internally, Executed inside the HeadlessFragment",
                Toast
                        .LENGTH_SHORT).show();
    }

    public void callFromOutside() {
        Toast.makeText(getContext(), "Called externally , Executed inside the HeadlessFragment",
                Toast
                        .LENGTH_SHORT).show();
    }
}