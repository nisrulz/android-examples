package github.nisrulz.sample.usingfirebasejobdispatcher;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;
import java.util.ArrayList;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

  /**
   * The Dispatcher.
   */
  FirebaseJobDispatcher dispatcher;

  ListView listView;
  ArrayList<String> actions;
  ArrayAdapter<String> adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // Create a new dispatcher using the Google Play driver.
    dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));

    listView = (ListView) findViewById(R.id.listview);
    actions = new ArrayList<>();
    actions.add("Schedule a Simple Job");
    actions.add("Cancel the Simple Job");
    actions.add("Schedule a Complex Job");
    actions.add("Cancel the Complex Job");
    actions.add("Cancel all Jobs");

    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, actions);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
          case 0:
            scheduleASimpleJob("simple-job");
            Toast.makeText(MainActivity.this, "Scheduled the Simple Job", Toast.LENGTH_SHORT)
                .show();
            break;
          case 1:
            cancelAJob("simple-job");
            Toast.makeText(MainActivity.this, "Cancelling the Simple Job", Toast.LENGTH_SHORT)
                .show();
            break;
          case 2:
            Bundle extraBundle = new Bundle();
            extraBundle.putString("some-key", "some-value");

            scheduleAComplexJob("complex-job", extraBundle);
            Toast.makeText(MainActivity.this, "Scheduled the Complex Job", Toast.LENGTH_SHORT)
                .show();
            break;
          case 3:
            cancelAJob("complex-job");
            Toast.makeText(MainActivity.this, "Cancelling the Complex Job", Toast.LENGTH_SHORT)
                .show();
            break;
          case 4:
            cancelAllJobs();
            Toast.makeText(MainActivity.this, "Cancelling all Jobs", Toast.LENGTH_SHORT).show();
            break;
        }
      }
    });
  }

  private void scheduleASimpleJob(String uniqueTag) {
    Job myJob = dispatcher.newJobBuilder()
        .setService(MyJobService.class) // the JobService that will be called
        .setTag(uniqueTag)        // uniquely identifies the job
        .build();

    dispatcher.mustSchedule(myJob);
  }

  private void scheduleAComplexJob(String uniqueTag, Bundle myExtrasBundle) {
    Job myJob = dispatcher.newJobBuilder()
        // the JobService that will be called
        .setService(MyJobService.class)
        // uniquely identifies the job
        .setTag(uniqueTag)
        // one-off job
        .setRecurring(false)
        // don't persist past a device reboot
        .setLifetime(Lifetime.UNTIL_NEXT_BOOT)
        // start between 0 and 60 seconds from now
        .setTrigger(Trigger.executionWindow(0, 60))
        // don't overwrite an existing job with the same tag
        .setReplaceCurrent(false)
        // retry with exponential backoff
        .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
        // constraints that need to be satisfied for the job to run
        .setConstraints(
            // only run on an unmetered network
            Constraint.ON_UNMETERED_NETWORK,
            // only run when the device is charging
            Constraint.DEVICE_CHARGING).setExtras(myExtrasBundle).build();

    dispatcher.mustSchedule(myJob);
  }

  private void cancelAJob(String uniqueTag) {
    dispatcher.cancel(uniqueTag);
  }

  private void cancelAllJobs() {
    dispatcher.cancelAll();
  }
}
