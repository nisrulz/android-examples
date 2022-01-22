package github.nisrulz.example.changethemeduringruntime

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import github.nisrulz.example.changethemeduringruntime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        // Call setTheme before supper constructor and setContentView
        setTheme(if (flag) R.style.AppThemeDark else R.style.AppThemeLight)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

            btnChange.setOnClickListener { // Flip the flag
                saveFlag(!flag)

                // Restart the same activity
                val intent = Intent(this@MainActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private val preferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }

    private fun saveFlag(flag: Boolean) {
        preferences.edit()
            .putBoolean("dark", flag)
            .apply()
    }

    private val flag: Boolean
        get() = preferences.getBoolean("dark", false)
}