package github.nisrulz.sample.snaphelper;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import android.view.Gravity;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private ArrayList<Item> items;
  private RecyclerView recyclerViewSnapCenter, recyclerViewSnapStart, recyclerViewSnapEnd;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Get ref to all views
    recyclerViewSnapCenter = (RecyclerView) findViewById(R.id.recycler_view_snap_center);
    recyclerViewSnapStart = (RecyclerView) findViewById(R.id.recycler_view_snap_start);
    recyclerViewSnapEnd = (RecyclerView) findViewById(R.id.recycler_view_snap_end);

    // Dummy list
    createAppsList();

    // Setup adapter
    SnapRecyclerAdapter adapter = new SnapRecyclerAdapter(items, this);


    // Snap Center
    SnapHelper snapHelper = new LinearSnapHelper();
    snapHelper.attachToRecyclerView(recyclerViewSnapCenter);
    recyclerViewSnapCenter.setAdapter(adapter);
    recyclerViewSnapCenter.setLayoutManager(
        new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    // Using library : GravitySnapHelper
    // Snap Start
    SnapHelper snapHelperGravityStart = new GravitySnapHelper(Gravity.START);
    snapHelperGravityStart.attachToRecyclerView(recyclerViewSnapStart);
    recyclerViewSnapStart.setAdapter(adapter);
    recyclerViewSnapStart.setLayoutManager(
        new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    // Snap End
    SnapHelper snapHelperGravityEnd = new GravitySnapHelper(Gravity.END);
    snapHelperGravityEnd.attachToRecyclerView(recyclerViewSnapEnd);
    recyclerViewSnapEnd.setAdapter(adapter);
    recyclerViewSnapEnd.setLayoutManager(
        new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


  }

  private void createAppsList() {
    items = new ArrayList<>();
    items.add(new Item("Google+", R.drawable.googleplus));
    items.add(new Item("Facebook", R.drawable.facebook));
    items.add(new Item("LinkedIn", R.drawable.linkedin));
    items.add(new Item("Youtube", R.drawable.youtube));
    items.add(new Item("Instagram", R.drawable.instagram));
    items.add(new Item("Skype", R.drawable.skype));
    items.add(new Item("Twitter", R.drawable.twitter));
    items.add(new Item("Pininterest", R.drawable.pinterest));
    items.add(new Item("Whatsapp", R.drawable.whatsapp));
    items.add(new Item("Spotify", R.drawable.spotify));
  }
}
