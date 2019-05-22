package github.nisrulz.simulateclick;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RelativeLayout relLay = (RelativeLayout) findViewById(R.id.relativeLayout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simulateClick(relLay);
            }
        });

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void simulateClick(final RelativeLayout relativeLayout) {
        long delta = 500;
        long downTime = SystemClock.uptimeMillis();

        // Set coordinate here to tap
        // in the middle of the relativeLayout
        float x = relativeLayout.getWidth() / 2;
        float y = relativeLayout.getHeight() / 2;

        final MotionEvent motionEvent_clickDown = MotionEvent.obtain(downTime, downTime + delta, MotionEvent.ACTION_DOWN, x, y, 0);
        final MotionEvent motionEvent_clickUp = MotionEvent.obtain(downTime + delta + 1, downTime + delta * 2, MotionEvent.ACTION_UP, x, y, 0);

        Runnable tapdown = new Runnable() {
            @Override
            public void run() {
                if (relativeLayout != null) {
                    relativeLayout.dispatchTouchEvent(motionEvent_clickDown);
                    System.out.println("Tapped Down");
                }
            }
        };

        Runnable tapup = new Runnable() {
            @Override
            public void run() {
                if (relativeLayout != null) {
                    relativeLayout.dispatchTouchEvent(motionEvent_clickUp);
                    System.out.println("Tapped Up");
                }
            }
        };

        int delay = 100;
        relativeLayout.postDelayed(tapdown, delay);
        delay += 100;
        relativeLayout.postDelayed(tapup, delay);
    }
}
