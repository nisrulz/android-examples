package github.nisrulz.example.boundservices

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.*
import android.widget.Toast

/** Command to the service to display a message  */
const val WHAT_MSG_DATA = 1
const val KEY_MSG_DATA = "data"

class MyBoundService : Service() {

    private val messenger by lazy { Messenger(IncomingHandler(applicationContext)) }

    override fun onBind(intent: Intent): IBinder? {
        Toast.makeText(
            applicationContext,
            "On Bind of Service", Toast.LENGTH_SHORT
        ).show()

        return messenger.binder
    }

    private class IncomingHandler(private val applicationContext: Context) :
        Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                WHAT_MSG_DATA -> {
                    val data = msg.data
                    val dataString = data.getString(KEY_MSG_DATA)
                    val textToDisplay = "Message received in Service : $dataString"
                    Toast.makeText(
                        applicationContext,
                        textToDisplay, Toast.LENGTH_SHORT
                    ).show()
                }
                else -> super.handleMessage(msg)
            }
        }
    }
}