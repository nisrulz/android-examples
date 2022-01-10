package github.nisrulz.example.animatedgradientbackground

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.animatedgradientbackground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var animationDrawable: AnimationDrawable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

            // initializing animation drawable by getting background from constraint layout
            animationDrawable = constraintLayout.background as AnimationDrawable
        }

        supportActionBar?.hide()

        animationDrawable?.apply {
            // setting enter fade animation duration to 5 seconds
            setEnterFadeDuration(5000)

            // setting exit fade animation duration to 2 seconds
            setExitFadeDuration(2000)
        }

    }

    override fun onResume() {
        super.onResume()
        if (animationDrawable != null && animationDrawable?.isRunning?.not() == true) {
            // start the animation
            animationDrawable?.start()
        }
    }

    override fun onPause() {
        super.onPause()
        if (animationDrawable != null && animationDrawable?.isRunning == true) {
            // stop the animation
            animationDrawable?.stop()
        }
    }
}