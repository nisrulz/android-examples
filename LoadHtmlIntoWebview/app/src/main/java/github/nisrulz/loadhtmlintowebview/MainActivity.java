package github.nisrulz.loadhtmlintowebview;

import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> data;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable Debugging WebViews
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        // Setup the list
        lv = (ListView) findViewById(R.id.listview_1);
        data = new ArrayList<>(2);
        data.add("Load a HTML File from assets");
        data.add("Load an HTML from a string");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);

        // Loadup the specific fragment
        final FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container_fragment, HTMLFileFragment
                .newInstance()).commit();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        fm.beginTransaction().replace(R.id.container_fragment, HTMLFileFragment
                                .newInstance()).commit();
                        break;
                    case 1:
                        fm.beginTransaction().replace(R.id.container_fragment, HTMLStringFragment
                                .newInstance()).commit();
                        break;
                    default:
                        fm.beginTransaction().replace(R.id.container_fragment, HTMLFileFragment
                                .newInstance()).commit();
                        break;
                }
            }
        });

    }
}
