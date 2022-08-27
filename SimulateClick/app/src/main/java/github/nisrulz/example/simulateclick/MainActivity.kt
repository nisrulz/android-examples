package github.nisrulz.example.simulateclick

import android.os.Bundle
import android.os.SystemClock
import android.view.MotionEvent
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.simulateclick.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            fab.setOnClickListener { simulateClick(relativeLayout) }
            button.setOnClickListener {
                Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun simulateClick(relativeLayout: RelativeLayout?) {
        val delta: Long = 500
        val downTime = SystemClock.uptimeMillis()

        // Set coordinate here to tap
        // in the middle of the relativeLayout
        val x = (relativeLayout!!.width / 2).toFloat()
        val y = (relativeLayout.height / 2).toFloat()
        val motioneventClickdown = MotionEvent
            .obtain(
                downTime,
                downTime + delta,
                MotionEvent.ACTION_DOWN, x, y, 0
            )
        val motioneventClickup = MotionEvent.obtain(
            downTime + delta + 1,
            downTime + delta * 2,
            MotionEvent.ACTION_UP, x, y, 0
        )
        val tapdown = Runnable {
            if (relativeLayout != null) {
                relativeLayout.dispatchTouchEvent(motioneventClickdown)
                println("Tapped Down")
            }
        }
        val tapup = Runnable {
            if (relativeLayout != null) {
                relativeLayout.dispatchTouchEvent(motioneventClickup)
                println("Tapped Up")
            }
        }
        var delay = 100
        relativeLayout.postDelayed(tapdown, delay.toLong())
        delay += 100
        relativeLayout.postDelayed(tapup, delay.toLong())
    }
}