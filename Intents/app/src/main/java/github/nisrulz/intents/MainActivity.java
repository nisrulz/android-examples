package github.nisrulz.intents;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    TextView textView_1;

    ListView lv;

    ArrayAdapter<String> adapter;

    ArrayList<String> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView_1 = findViewById(R.id.textView_1);

        data = new ArrayList<>();
        data.add("Explicit Intent with Parceable Object");
        data.add("Explicit Intent for Result");

        lv = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        launchExplicitIntentWithParceableObj();
                        break;
                    case 1:
                        launchExplicitIntentForResult();
                        break;
                }
            }
        });
    }


    /**
     * Explicit Intent
     */
    private void launchExplicitIntentWithParceableObj() {
        // first parameter is the context, second is the class of the activity to launch
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        POJOClass pojoClass = new POJOClass("Radix", "This is some text");
        i.putExtra("data", pojoClass);
        i.putExtra("type", "pojo");
        startActivity(i); // brings up the second activity
    }

    /**
     * Explicit Intent For Result
     */
    private void launchExplicitIntentForResult() {
        Bundle bundle = new Bundle();
        bundle.putInt("number", 10);
        bundle.putString("text", "This is text sent from MainActivity");

        // first parameter is the context, second is the class of the activity to launch
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        i.putExtra("bundle", bundle);
        i.putExtra("type", "result");
        startActivityForResult(i, 100); // brings up the second activity
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 100 && data != null) {
                Bundle bundle = data.getBundleExtra("returndata");
                String text = bundle.getString("text");

                Toast.makeText(MainActivity.this, "Text Received : " + text, Toast.LENGTH_LONG).show();
            }
        }
    }
}
