package github.nisrulz.example.appshortcuts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.appshortcuts.databinding.ActivityStaticShortcutBinding

class StaticShortcutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStaticShortcutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStaticShortcutBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
        }
    }
}