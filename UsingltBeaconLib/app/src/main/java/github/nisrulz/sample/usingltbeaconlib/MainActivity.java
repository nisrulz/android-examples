package github.nisrulz.sample.usingltbeaconlib;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import java.util.Collection;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

public class MainActivity extends AppCompatActivity implements BeaconConsumer {
  protected static final String TAG = "MonitoringActivity";
  private BeaconManager beaconManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    beaconManager = BeaconManager.getInstanceForApplication(this);
    // To detect proprietary beacons, you must add a line like below corresponding to your beacon
    // type.  Do a web search for "setBeaconLayout" to get the proper expression.
    // beaconManager.getBeaconParsers().add(new BeaconParser().
    //        setBeaconLayout("m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));
    beaconManager.bind(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    beaconManager.unbind(this);
  }

  @Override public void onBeaconServiceConnect() {
    beaconManager.setMonitorNotifier(new MonitorNotifier() {
      @Override public void didEnterRegion(Region region) {
        Log.i(TAG, "I just saw an beacon for the first time!");
      }

      @Override public void didExitRegion(Region region) {
        Log.i(TAG, "I no longer see an beacon");
      }

      @Override public void didDetermineStateForRegion(int state, Region region) {
        Log.i(TAG, "I have just switched from seeing/not seeing beacons: " + state);
      }
    });

    beaconManager.setRangeNotifier(new RangeNotifier() {
      @Override public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
        if (beacons.size() > 0) {
          Log.i(TAG, "The first beacon I see is about "
              + beacons.iterator().next().getDistance()
              + " meters away.");
        }
      }
    });

    try {
      beaconManager.startMonitoringBeaconsInRegion(
          new Region("myMonitoringUniqueId", null, null, null));
    } catch (RemoteException e) {
    }

    try {
      beaconManager.startRangingBeaconsInRegion(new Region("myRangingUniqueId", null, null, null));
    } catch (RemoteException e) {
    }
  }
}
