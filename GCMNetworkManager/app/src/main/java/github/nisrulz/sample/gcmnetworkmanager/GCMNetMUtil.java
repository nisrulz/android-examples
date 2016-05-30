package github.nisrulz.sample.gcmnetworkmanager;

import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task;

public class GCMNetMUtil {

  private GcmNetworkManager mGcmNetworkManager;
  private Context context;
  private GoogleApiAvailability googleAPI;

  public GCMNetMUtil(Context context) {
    this.context = context;
    mGcmNetworkManager = GcmNetworkManager.getInstance(context);
    googleAPI = GoogleApiAvailability.getInstance();
  }

  void oneOffTask() {
    Task task = new OneoffTask.Builder().setService(CustomService.class)
        .setExecutionWindow(0, 30) //in seconds
        .setTag(CustomService.TAG_TASK_ONEOFF_LOG)
        .setUpdateCurrent(false)
        .setRequiredNetwork(Task.NETWORK_STATE_CONNECTED)
        .setRequiresCharging(false)
        .build();

    if (checkPlayServices()) {
      mGcmNetworkManager.schedule(task);
    } else {
      // Deal with this networking task some other way
    }
  }

  void periodicTask() {
    Task task =
        new PeriodicTask.Builder().setService(CustomService.class).setPeriod(30) //in seconds
            .setFlex(10).setTag(CustomService.TAG_TASK_PERIODIC_LOG).setPersisted(true).build();

    if (checkPlayServices()) {
      mGcmNetworkManager.schedule(task);
    } else {
      // Deal with this networking task some other way
    }
  }

  // In either case, remember that an in-flight task cannot be canceled.

  void cancelAllTasks() {
    mGcmNetworkManager.cancelAllTasks(CustomService.class);
  }

  void cancelSpecificTask() {
    mGcmNetworkManager.cancelTask(CustomService.TAG_TASK_PERIODIC_LOG, CustomService.class);
  }

  private boolean checkPlayServices() {
    int result = googleAPI.isGooglePlayServicesAvailable(context);
    if (result != ConnectionResult.SUCCESS) {
      return false;
    }

    return true;
  }
}
