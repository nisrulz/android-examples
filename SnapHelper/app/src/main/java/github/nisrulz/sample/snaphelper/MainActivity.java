package github.nisrulz.sample.snaphelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private ArrayList<Item> items;
  private RecyclerView recyclerView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

    createApps();

    /**
     * Center snapping
     */
    SnapHelper snapHelper = new LinearSnapHelper();
    snapHelper.attachToRecyclerView(recyclerView);

    SnapRecyclerAdapter adapter = new SnapRecyclerAdapter(items,this);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this,
        LinearLayoutManager.HORIZONTAL, false));
  }

  private void createApps() {
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
