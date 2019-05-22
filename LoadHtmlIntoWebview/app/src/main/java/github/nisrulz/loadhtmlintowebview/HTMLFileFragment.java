package github.nisrulz.loadhtmlintowebview;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HTMLFileFragment extends Fragment {


    public HTMLFileFragment() {
        // Required empty public constructor
    }

    public static HTMLFileFragment newInstance() {
        return new HTMLFileFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_htmlfile, container, false);
        WebView webView = (WebView) view.findViewById(R.id.webview_1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(Defaults.PATH_TO_ASSETS_FOLDER + "app/index.html?val=100");

        return view;
    }

}
