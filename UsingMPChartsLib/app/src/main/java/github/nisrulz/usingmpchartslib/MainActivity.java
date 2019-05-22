package github.nisrulz.usingmpchartslib;

import android.os.Bundle;
import android.os.Handler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  // Library at  : https://github.com/PhilJay/MPAndroidChart/

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Using MPAndroidCharts 3.0.1", Snackbar.LENGTH_LONG).show();
      }
    });

    // Data Sets
    ArrayList<BarEntry> entries = new ArrayList<>();
    entries.add(new BarEntry(4f, 0));
    entries.add(new BarEntry(8f, 1));
    entries.add(new BarEntry(6f, 2));
    entries.add(new BarEntry(12f, 3));
    entries.add(new BarEntry(18f, 4));
    entries.add(new BarEntry(9f, 5));
    BarDataSet dataset = new BarDataSet(entries, "# of Calls");

    // Declare the bar chart and set it as the view for this activity
    final BarChart chart = (BarChart) findViewById(R.id.bar_chart);

    // Set data for the bar chart
    BarData data = new BarData(dataset);
    chart.setData(data);
    chart.setFitBars(true); // make the x-axis fit exactly all bars

    // Set description
    Description description = new Description();
    description.setText("# of times Alice called Bob");
    chart.setDescription(description);

    // Set themes
    dataset.setColors(ColorTemplate.COLORFUL_COLORS);

    // Animate
    chart.animateY(5000);

    // Save the chart aftre its drawn
    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        // Save the chart to gallery/path
        chart.saveToGallery("mychart.jpg", 85); // 85 is the quality of the image
      }
    }, 2000);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
