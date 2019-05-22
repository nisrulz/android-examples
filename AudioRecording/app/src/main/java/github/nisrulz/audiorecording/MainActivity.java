package github.nisrulz.audiorecording;

import android.os.Bundle;
import android.os.Environment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String LOGTAG = getClass().getSimpleName().toString();
    String mFileName = null;

    RecordAudio recordAudio = new RecordAudio();
    PlayAudio playAudio = new PlayAudio();

    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/audiorecord.3gp";

        final FloatingActionButton fab_rec = (FloatingActionButton) findViewById(R.id.fab_rec);
        txt=(TextView)findViewById(R.id.txt);

        txt.setText("Press and hold record button to record");

        fab_rec.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        txt.setText("Recording Started");
                        recordAudio.startRecording(mFileName);
                        break;
                    case MotionEvent.ACTION_UP:
                        txt.setText("Press and hold record button to record\nRecording Stopped");
                        recordAudio.stopRecording();
                        break;
                }
                return true;
            }
        });

        FloatingActionButton fab_play = (FloatingActionButton) findViewById(R.id.fab_play);
        fab_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playAudio.isPlaying()) {
                    txt.setText("Press and hold record button to record\nAudio play stopped");
                    playAudio.stopPlaying();
                } else {
                    txt.setText("Audio play started");
                    playAudio.startPlaying(mFileName);
                }
            }
        });
    }


    @Override
    public void onPause() {
        super.onPause();

        recordAudio.releaseMediaRecorder();
        playAudio.releaseMedidaPalyer();
    }
}
