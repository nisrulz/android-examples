package github.nisrulz.sample.gcmnetworkmanager;

import android.util.Log;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;

public class CustomService extends GcmTaskService {

  private static final String TAG = "CustomService";
  public static final String TAG_TASK_ONEOFF_LOG = "one_off_task";
  public static final String TAG_TASK_PERIODIC_LOG = "periodic_task";

  @Override public int onRunTask(TaskParams taskParams) {
    Log.i(TAG, "onRunTask");
    switch (taskParams.getTag()) {
      case TAG_TASK_ONEOFF_LOG:
        Log.i(TAG, TAG_TASK_ONEOFF_LOG);
        // This is where useful work would go
        return GcmNetworkManager.RESULT_SUCCESS;
      case TAG_TASK_PERIODIC_LOG:
        Log.i(TAG, TAG_TASK_PERIODIC_LOG);
        // This is where useful work would go
        return GcmNetworkManager.RESULT_SUCCESS;
      default:
        return GcmNetworkManager.RESULT_FAILURE;
    }
  }

  @Override public void onInitializeTasks() {
    super.onInitializeTasks();

    // Reschedule removed tasks here
    GCMNetMUtil gcmNetMUtil = new GCMNetMUtil(this);

    // One Off Task
    gcmNetMUtil.oneOffTask();

    // Periodic Task
    gcmNetMUtil.periodicTask();
  }
}
