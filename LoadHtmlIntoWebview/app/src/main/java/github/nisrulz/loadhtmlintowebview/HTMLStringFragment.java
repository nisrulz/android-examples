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
public class HTMLStringFragment extends Fragment {


    public HTMLStringFragment() {
        // Required empty public constructor
    }

    public static HTMLStringFragment newInstance() {
        return new HTMLStringFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_htmlstring, container, false);
        WebView webView = (WebView) view.findViewById(R.id.webview_2);
        webView.getSettings().setJavaScriptEnabled(true);

        String htmlData =
                "<html><body style ='background:#2E608E; color:white; padding : 3em'>"
                        + "This is a text inside <b>HTML Body</b>, with <i>inline css</i> :D "
                        + "</body></html>";

        if (htmlData != null) {
            webView.loadData(htmlData, "text/html", "UTF-8");
        }

        return view;
    }
}
