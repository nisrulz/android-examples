package github.nisrulz.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

const val BR_ACTION = "github.nisrulz.example.broadcastreceiver.action.MY_ACTION"
const val BR_INTENT_BUNDLE_KEY = "data"

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            BR_ACTION -> {
                val data = intent.getStringExtra(BR_INTENT_BUNDLE_KEY)
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show()
            }
        }
    }
}