package github.nisrulz.example.usingtimberlogger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.usingtimberlogger.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
        }

        // Log using Timber
        // Debug/Info/Verbose is not logged in release mode
        val str = "This is NOT logged in release mode"
        Timber.d(str)
        Timber.i(str)
        Timber.v(str)
        // Warn/Error/WTF is logged in release mode
        val str2 = "This is logged in release mode"
        Timber.w(str2)
        Timber.e(RuntimeException(str2))
        Timber.wtf(RuntimeException(str2))
    }
}