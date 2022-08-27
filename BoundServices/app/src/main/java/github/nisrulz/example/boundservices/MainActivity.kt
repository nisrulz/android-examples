package github.nisrulz.example.boundservices

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.boundservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var myService: Messenger? = null
    private var isBound = false

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            fab.setOnClickListener {
                sendMessage()
            }

            bindService()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        // Unbind from service so as to not leak the service connection
        unbindService(myServiceConnection)
    }

    private fun bindService() {
        val intent = Intent(applicationContext, MyBoundService::class.java)
        bindService(intent, myServiceConnection, BIND_AUTO_CREATE)
    }


    private fun sendMessage() {
        if (!isBound) return

        val msg = Message.obtain()
        msg.what = WHAT_MSG_DATA

        val bundle = Bundle()
        bundle.putString(KEY_MSG_DATA, "Hello World!")
        msg.data = bundle
        try {
            myService?.send(msg)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    // Service Connection
    private val myServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(
            className: ComponentName,
            service: IBinder
        ) {
            myService = Messenger(service)
            isBound = true
        }

        override fun onServiceDisconnected(className: ComponentName) {
            myService = null
            isBound = false
        }
    }
}