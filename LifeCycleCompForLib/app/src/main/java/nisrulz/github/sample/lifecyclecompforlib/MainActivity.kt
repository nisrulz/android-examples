package nisrulz.github.sample.lifecyclecompforlib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nisrulz.github.sample.awesomelib.AwesomeLibMain

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    // Add Lifecycle Observer
    lifecycle.addObserver(AwesomeLibMain.instance)
  }

  override fun onDestroy() {
    super.onDestroy()
    // Remove Lifecycle Observer
    lifecycle.removeObserver(AwesomeLibMain.instance)
  }
}