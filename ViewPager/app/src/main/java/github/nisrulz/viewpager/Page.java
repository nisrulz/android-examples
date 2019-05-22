package github.nisrulz.viewpager;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Page extends Fragment {

    // Store instance variables
    private String title;
    private int page;


    public Page() {
        // Required empty public constructor
    }


    public static Page newInstance(int page_number, String title) {
        Page fragment = new Page();
        Bundle args = new Bundle();
        args.putInt("page", page_number);
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        page = getArguments().getInt("page", 0);
        title = getArguments().getString("title");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        ((TextView) view.findViewById(R.id.text)).
                setText(page + " - " + title);
        return view;
    }
}
