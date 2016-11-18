package github.nisrulz.sample.usingfirebasejobdispatcher;

import android.util.Log;
import android.widget.Toast;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class MyJobService extends JobService {

  private static final String LOGTAG = "My Job Service";

  @Override
  public boolean onStartJob(JobParameters job) {
    // Do some work here
    Toast.makeText(this, "Job Started! Yay :D", Toast.LENGTH_SHORT).show();
    Log.i(LOGTAG, "Job Started! Yay :D");

    return false; // Answers the question: "Is there still work going on?"
  }

  @Override
  public boolean onStopJob(JobParameters job) {
    return false; // Answers the question: "Should this job be retried?"
  }
}