package github.nisrulz.gridview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridViewSample;
    static final String[] gridViewStringValue = new String[]{
            "Grid A", "Grid B", "Grid C", "Grid D", "Grid E", "Grid F", "Grid G", "Grid H", "Grid I", "Grid J",
            "Grid K", "Grid L", "Grid M", "Grid N", "Grid O", "Grid P", "Grid Q", "Grid R", "Grid S", "Grid T",
            "Grid U", "Grid V", "Grid W", "Grid X", "Grid Y", "Grid Z", "Grid View 1", "Grid " +
            "View 2", "Grid View 3", "Grid View 4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewSample = (GridView) findViewById(R.id.simple_grid_view_example);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, gridViewStringValue);
        gridViewSample.setAdapter(adapter);

        gridViewSample.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) v).getText() + " is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
