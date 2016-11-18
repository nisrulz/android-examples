package github.nisrulz.sample.usingfirebasejobdispatcher;

import android.util.Log;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class MyJobService extends JobService {
  private static final String LOGTAG = "MyJobService";

  @Override
  public boolean onStartJob(JobParameters job) {
    // Do some work here
    Log.d(LOGTAG, "Job Started! Yay :D");

    return false; // Answers the question: "Is there still work going on?"
  }

  @Override
  public boolean onStopJob(JobParameters job) {
    return false; // Answers the question: "Should this job be retried?"
  }
}