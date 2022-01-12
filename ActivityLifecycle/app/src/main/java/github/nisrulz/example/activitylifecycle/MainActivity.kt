package github.nisrulz.example.activitylifecycle

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.activitylifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }

        LogData("onCreate Called")
    }

    override fun onStart() {
        super.onStart()
        LogData("onStart Called")
    }

    override fun onRestart() {
        super.onRestart()
        LogData("onRestart Called")
    }

    override fun onPause() {
        super.onPause()
        LogData("onPause Called")
    }

    override fun onResume() {
        super.onResume()
        LogData("onResume Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogData("onDestroy Called")
    }

    private fun LogData(data: String?) {
        Toast.makeText(this@MainActivity, data, Toast.LENGTH_SHORT).show()
        Log.d("TAG", data!!)
    }
}