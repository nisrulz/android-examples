package github.nisrulz.example.appshortcuts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.appshortcuts.databinding.ActivityDynamicShortcutBinding

class DynamicShortcutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDynamicShortcutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicShortcutBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }
    }

    companion object {
        const val ACTION: String = BuildConfig.APPLICATION_ID + ".OPEN_DYNAMIC_SHORTCUT"
    }
}