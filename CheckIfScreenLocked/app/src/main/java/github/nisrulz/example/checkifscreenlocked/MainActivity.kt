package github.nisrulz.example.checkifscreenlocked

import android.app.KeyguardManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.checkifscreenlocked.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val LOGTAG = "CheckIfScreenLocked"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }

        registerScreenLockStateBroadcastReceiver()
    }

    override fun onDestroy() {
        super.onDestroy()
        applicationContext.unregisterReceiver(screenOnOffReceiver)
    }

    private fun registerScreenLockStateBroadcastReceiver() {
        IntentFilter().apply {
            /** System Defined Broadcast  */
            addAction(Intent.ACTION_SCREEN_ON)
            addAction(Intent.ACTION_SCREEN_OFF)
            addAction(Intent.ACTION_USER_PRESENT)
        }.also {
            applicationContext.registerReceiver(screenOnOffReceiver, it)
        }
    }

    private val kgMgr by lazy { getSystemService(KEYGUARD_SERVICE) as KeyguardManager }
    private val screenOnOffReceiver: BroadcastReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            when (intent.action) {
                Intent.ACTION_SCREEN_OFF -> {
                    Log.d(LOGTAG, "Screen Off")
                }
                Intent.ACTION_SCREEN_ON -> {
                    Log.d(LOGTAG, "Screen On")
                }
            }

            when {
                isDeviceUnlocked(intent) -> {
                    Log.d(LOGTAG, "Device UNLOCKED")
                }
                else -> {
                    Log.d(LOGTAG, "Device LOCKED")
                }
            }
        }
    }

    private fun isDeviceUnlocked(intent: Intent) =
        intent.action == Intent.ACTION_USER_PRESENT
                && checkIfKeyguardIsLocked().not()

    private fun checkIfKeyguardIsLocked(): Boolean {
        return if (SDK_INT > 28) {
            kgMgr.isKeyguardLocked
        } else {
            kgMgr.inKeyguardRestrictedInputMode()
        }
    }
}