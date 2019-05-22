package github.nisrulz.example.camera2;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        goFullScreen(this);
        hideActionBar(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2Fragment.newInstance())
                    .commit();
        }
    }


    void goFullScreen(Activity activity) {
        // Call before calling setContentView();
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager
                .LayoutParams
                .FLAG_FULLSCREEN);
    }

    void hideActionBar(Activity activity) {
        // Call before calling setContentView();
        activity.getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
    }
}
