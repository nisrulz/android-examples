package github.nisrulz.example.usingltbeaconlib

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import github.nisrulz.example.usingltbeaconlib.databinding.ActivityMainBinding
import org.altbeacon.beacon.Beacon
import org.altbeacon.beacon.BeaconManager
import org.altbeacon.beacon.MonitorNotifier
import org.altbeacon.beacon.Region

class MainActivity : AppCompatActivity() {
    private val beaconManager by lazy {
        BeaconManager.getInstanceForApplication(this)
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            setupBeaconMonitoring()
        }
    }


    private fun setupBeaconMonitoring(lifecycleOwner: LifecycleOwner = this) {
        // TODO: Add code here to obtain location permission from user
        // TODO: Add beaconParsers for any properietry beacon formats you wish to detect
        // To detect proprietary beacons, you must add a line like below corresponding to your beacon
        // type.  Do a web search for "setBeaconLayout" to get the proper expression.
        // beaconManager.getBeaconParsers().add(new BeaconParser().
        //        setBeaconLayout("m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));

        val region = Region("all-beacons-region", null, null, null)
        // Set up a Live Data observer so this Activity can get monitoring callbacks
        beaconManager.getRegionViewModel(region).apply {
            // observer will be called each time the monitored regionState changes (inside vs. outside region)
            regionState.observe(lifecycleOwner, monitoringObserver)
            // observer will be called each time the monitored rangedBeacons changes
            rangedBeacons.observe(lifecycleOwner, rangingObserver)
        }

        beaconManager.startMonitoring(region)
    }

    private val monitoringObserver = Observer<Int> { state ->
        if (state == MonitorNotifier.INSIDE) {
            Log.d(TAG, "Detected beacons(s)")
        } else {
            Log.d(TAG, "Stopped detecteing beacons")
        }
    }

    val rangingObserver = Observer<Collection<Beacon>> { beacons ->
        Log.d(TAG, "Ranged: ${beacons.count()} beacons")
        for (beacon: Beacon in beacons) {
            Log.d(TAG, "$beacon about ${beacon.distance} meters away")
        }
    }


    companion object {
        private const val TAG = "MonitoringActivity"
    }
}