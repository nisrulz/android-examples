package github.nisrulz.sample.appshortcuts;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

/** This is a small demo project for setting up the new App Shortcuts feature from Android 7.1
 *  The official documentation can be found at: https://developer.android.com/preview/shortcuts.html
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** App Shortcuts are great for exposing actions of your app and bring back users into your flow
         * they can be static or dynamic
         * static are set in stone once you define them (you can only update them with an app redeploy)
         * dynamic can be changed on the fly
         */

        final ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

        /**
         * Dynamic Shortcuts
         * By setting a custom rank to a dynamic shortcut we can control the order they appear when revealed:
         * the higher the rank, the most top the shortcut goes.
         * the rank of a static shortcut cannot be changed they will be shown in the order they're defined in the shortcuts.xml file.
         */

        ShortcutInfo browserShortcut = new ShortcutInfo.Builder(this, "shortcut_browser")
                .setShortLabel("google.com")
                .setLongLabel("open google.com")
                .setDisabledMessage("dynamic shortcut disable")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_open_in_browser))
                .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")))
                .setRank(0)
                .build();

        ShortcutInfo dynamicShortcut = new ShortcutInfo.Builder(this, "dynamic shortcut")
                .setShortLabel("Dynamic")
                .setLongLabel("Open dynamic shortcut")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_dynamic))
                .setIntents(
                        new Intent[]{
                                new Intent(Intent.ACTION_MAIN, Uri.EMPTY, this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK),
                                new Intent(DynamicShortcutActivity.ACTION)
                        })
                .setRank(1)
                .build();

        shortcutManager.setDynamicShortcuts(Arrays.asList(browserShortcut, dynamicShortcut));

        /**
         * updating the shortcuts
         * we can updates the shortcut by making the use of updateShortcuts() method.
         */
        Button updateShortcutsBtn = (Button) findViewById(R.id.update_shortcuts);
        updateShortcutsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForegroundColorSpan colorSpan = new ForegroundColorSpan(getResources().getColor(android.R.color.holo_red_light, getTheme()));
                String label = "open google.com";

                SpannableStringBuilder colouredLabel = new SpannableStringBuilder(label);
                colouredLabel.setSpan(colorSpan, 0, label.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);

                ShortcutInfo browserShortcut = new ShortcutInfo.Builder(MainActivity.this, "shortcut_browser")
                        .setShortLabel(colouredLabel)
                        .setRank(1)
                        .build();

                ShortcutInfo dynamicShortcut = new ShortcutInfo.Builder(MainActivity.this, "dynamic shortcut")
                        .setRank(0)
                        .build();

                shortcutManager.updateShortcuts(Arrays.asList(browserShortcut, dynamicShortcut));

                Toast.makeText(MainActivity.this, "Shortcuts Updated :)", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * Disabling app shortcut
         * disableShortcuts(List) will remove the specified dynamic shortcuts and also make any
         * specified pinned shortcuts un-launchable.
         */


        Button disableShortcutBtn = (Button) findViewById(R.id.disable_shortcut);
        disableShortcutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shortcutManager.disableShortcuts(Arrays.asList("dynamic shortcut"));
                Toast.makeText(MainActivity.this, "Dynamic shortcut Disabled !!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
