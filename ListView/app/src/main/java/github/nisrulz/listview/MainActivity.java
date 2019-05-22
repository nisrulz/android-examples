package github.nisrulz.listview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> data;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listview_1);
        data = new ArrayList<>();
        data.add("Apple");
        data.add("Peach");
        data.add("Pineapple");
        data.add("Banana");
        data.add("Orange");
        data.add("Watermelon");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                // Show a Toast message on item  click
                Toast.makeText(MainActivity.this, "You clicked : " + data.get(pos), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
