package github.nisrulz.recyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv;
    ArrayList<String> data;
    RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv_fruits);

        data = new ArrayList<>();
        data.add("Apple");
        data.add("Banana");
        data.add("Peach");
        data.add("Pineapple");
        data.add("Orange");
        data.add("Strawberry");
        data.add("Grapes");
        data.add("Apricot");
        data.add("Avocado");
        data.add("Raisin");
        data.add("Guava");
        data.add("Papaya");
        data.add("Pear");
        data.add("Blueberry");
        data.add("Lychee");
        data.add("Date");
        data.add("Fig");

        adapter = new RVAdapter(data);
        rv.hasFixedSize();
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);


        // Setup onItemTouchHandler
        ItemTouchHelper.Callback callback = new RVOnItemtouchHelper(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rv);

        // Set the divider
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // Set On Click
        rv.addOnItemTouchListener(new RVItemClickListener(this, new RVItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String value = "Clicked Item " + data.get(position) + " at " + position;

                Log.d("TAG", value);
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        }));

    }
}
