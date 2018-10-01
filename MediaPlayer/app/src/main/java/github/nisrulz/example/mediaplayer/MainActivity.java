package github.nisrulz.example.mediaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

// Contributed by Sergio Morales (@Fireblend)

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MediaPlayer mMediaPlayer;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                } else {
                    mMediaPlayer.start();
                }
                btn.setText(mMediaPlayer.isPlaying() ? "Pause" : "Resume");
            }
        });

        setup();
    }

    private void setup() {
        try {
            //An audio stream
            String url = "https://bitdash-a.akamaihd.net/content/sintel/hls/playlist.m3u8";

            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setDataSource(url);
            mMediaPlayer.setOnPreparedListener(this);

            //Prepare the stream asynchronously
            mMediaPlayer.prepareAsync();
        } catch (Exception e) {
            Log.d(TAG, "Error");
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        //Enable button once ready
        btn.setEnabled(true);
        btn.setText("Play");
    }
}
