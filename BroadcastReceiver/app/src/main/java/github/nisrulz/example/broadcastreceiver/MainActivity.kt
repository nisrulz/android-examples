package github.nisrulz.example.broadcastreceiver

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.text.TextUtils
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.broadcastreceiver.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val myBroadcastReceiver = MyBroadcastReceiver()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            btn.setOnClickListener {
                val dataStr = editTxtMsg.text.toString()
                hideKeyboard()

                if (TextUtils.isEmpty(dataStr)) {
                    Toast.makeText(
                        applicationContext,
                        "Please enter a message to broadcast",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    broadcastMessage(dataStr)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        IntentFilter().apply {
            addAction(BR_ACTION)
            registerReceiver(myBroadcastReceiver, this)
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(myBroadcastReceiver)
    }

    private fun broadcastMessage(dataStr: String) {
        val intent = Intent(BR_ACTION)
        intent.putExtra(BR_INTENT_BUNDLE_KEY, dataStr)
        sendBroadcast(intent)
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(
            currentFocus?.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}