package github.nisrulz.example.camera2

import github.nisrulz.example.camera2.Camera2Fragment.Companion.newInstance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import github.nisrulz.example.camera2.R
import github.nisrulz.example.camera2.Camera2Fragment
import android.app.Activity
import android.view.WindowManager
import android.view.Window

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        goFullScreen(this)
        hideActionBar(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (null == savedInstanceState) {
            fragmentManager.beginTransaction()
                .replace(R.id.container, newInstance())
                .commit()
        }
    }

    fun goFullScreen(activity: Activity) {
        // Call before calling setContentView();
        activity.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    fun hideActionBar(activity: Activity) {
        // Call before calling setContentView();
        activity.window.requestFeature(Window.FEATURE_ACTION_BAR)
        supportActionBar!!.hide()
    }
}