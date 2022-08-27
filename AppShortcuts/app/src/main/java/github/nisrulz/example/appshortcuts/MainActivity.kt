package github.nisrulz.example.appshortcuts

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.appshortcuts.MainActivity
import github.nisrulz.example.appshortcuts.databinding.ActivityMainBinding
import java.util.*

/** This is a small demo project for setting up the new App Shortcuts feature from Android 7.1
 * The official documentation can be found at: https://developer.android.com/preview/shortcuts.html
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /*
       * App Shortcuts are great for exposing actions of your app and bring back users into your flow
       * they can be static or dynamic
       * static are set in stone once you define them (you can only update them with an app redeploy)
       * dynamic can be changed on the fly
       */
    private val shortcutManager by lazy { getSystemService(ShortcutManager::class.java) }

    private val ID_SHORTCUT_BROWSER = "shortcut_browser"
    private val ID_UPDATE_SHORTCUT = "dynamic_shortcut"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            setupShortcuts()
            /**
             * Updating the shortcuts
             * we can updates the shortcut by making the use of updateShortcuts() method.
             */
            btnUpdateShortcut.setOnClickListener {
                updateShortcuts()
                Toast.makeText(this@MainActivity, "Shortcuts Updated", Toast.LENGTH_SHORT).show()
            }
            /**
             * Disabling app shortcut
             * disableShortcuts(List) will remove the specified dynamic shortcuts and also make any
             * specified pinned shortcuts un-launchable.
             */
            btnDisableShortcut.setOnClickListener {
                disableDynamicShortcut()
                Toast.makeText(this@MainActivity, "Dynamic shortcut Disabled !", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun setupShortcuts() {

        /*
         * Dynamic Shortcuts
         * By setting a custom rank to a dynamic shortcut we can control the order they appear when revealed:
         * the higher the rank, the most top the shortcut goes.
         * the rank of a static shortcut cannot be changed they will be shown in the order they're defined in the shortcuts.xml file.
         */
        val browserShortcut = ShortcutInfo.Builder(this, ID_SHORTCUT_BROWSER)
            .setShortLabel("google.com")
            .setLongLabel("open google.com")
            .setDisabledMessage("dynamic shortcut disable")
            .setIcon(Icon.createWithResource(this, R.drawable.ic_open_in_browser))
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")))
            .setRank(0)
            .build()
        val dynamicShortcut = ShortcutInfo.Builder(this, ID_UPDATE_SHORTCUT)
            .setShortLabel("Dynamic")
            .setLongLabel("Open dynamic shortcut")
            .setIcon(Icon.createWithResource(this, R.drawable.ic_dynamic))
            .setIntents(
                arrayOf(
                    Intent(
                        Intent.ACTION_MAIN,
                        Uri.EMPTY,
                        this,
                        MainActivity::class.java
                    ).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK),
                    Intent(DynamicShortcutActivity.ACTION)
                )
            )
            .setRank(1)
            .build()

        shortcutManager.dynamicShortcuts = listOf(browserShortcut, dynamicShortcut)
    }

    private fun updateShortcuts() {
        val colorSpan =
            ForegroundColorSpan(resources.getColor(android.R.color.holo_red_light, theme))
        val label = "open google.com"
        val colouredLabel = SpannableStringBuilder(label)
        colouredLabel.setSpan(colorSpan, 0, label.length, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        val browserShortcut = ShortcutInfo.Builder(this@MainActivity, ID_SHORTCUT_BROWSER)
            .setShortLabel(colouredLabel)
            .setRank(1)
            .build()
        val dynamicShortcut = ShortcutInfo.Builder(this@MainActivity, ID_UPDATE_SHORTCUT)
            .setRank(0)
            .build()
        shortcutManager.updateShortcuts(listOf(browserShortcut, dynamicShortcut))
    }

    private fun disableDynamicShortcut() {
        shortcutManager.disableShortcuts(listOf(ID_UPDATE_SHORTCUT))
    }
}