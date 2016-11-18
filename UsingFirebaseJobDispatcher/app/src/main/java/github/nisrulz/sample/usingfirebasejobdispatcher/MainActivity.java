package github.nisrulz.sample.usingfirebasejobdispatcher;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

  /**
   * The Dispatcher.
   */
  FirebaseJobDispatcher dispatcher;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // Create a new dispatcher using the Google Play driver.
    dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        scheduleASimpleJob("my-unique-tag");
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
