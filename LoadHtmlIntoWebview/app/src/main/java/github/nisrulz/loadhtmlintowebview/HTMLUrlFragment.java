package github.nisrulz.loadhtmlintowebview;


import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class HTMLUrlFragment extends Fragment {


    public HTMLUrlFragment() {
        // Required empty public constructor
    }

    public static HTMLUrlFragment newInstance() {
        return new HTMLUrlFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_htmlfile, container, false);
      WebView webView = (WebView) view.findViewById(R.id.webview_1);
      webView.getSettings().setJavaScriptEnabled(true);


      webView.setWebViewClient(new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
          view.loadUrl(url);
          return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
          handler.proceed();
        }
      });

      webView.loadUrl("https://visit4.me/");

        return view;
    }

}
