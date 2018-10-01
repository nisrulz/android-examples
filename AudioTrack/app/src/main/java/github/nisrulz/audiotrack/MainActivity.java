package github.nisrulz.audiotrack;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

// Contributed by Sergio Morales (@Fireblend)

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private boolean stopped = true;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stopped) {
                    new Thread(new PlaybackRunnable()).start();
                    stopped = false;
                    button.setText("Stop");
                } else {
                    stopped = true;
                    button.setText("Play");
                }
            }
        });
    }

    class PlaybackRunnable implements Runnable {
        @Override
        public void run() {
            InputStream is = null;

            try {
                is = getResources().openRawResource(R.raw.sample);

                int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
                int channelConfig = AudioFormat.CHANNEL_OUT_STEREO;
                int sampleRate = 8000;

                AudioTrack track;

                int bufferSize = AudioTrack.getMinBufferSize(sampleRate, channelConfig, audioFormat);

                track = new AudioTrack(AudioManager.STREAM_MUSIC, sampleRate,
                        channelConfig, audioFormat,
                        bufferSize, AudioTrack.MODE_STREAM);

                byte[] music = toByteArray(is);

                track.play();
                int offsetSize = 0;

                while (offsetSize < music.length && !stopped) {
                    if ((offsetSize + bufferSize) < music.length) {
                    } else {
                        bufferSize = music.length - offsetSize;
                    }
                    track.write(music, offsetSize, bufferSize);
                    offsetSize += bufferSize;
                }

                track.flush();
                track.stop();
                track.release();
                is.close();
            } catch (Exception e) {
                if (is != null) {
                    try {
                        is.close();
                    } catch (Exception innerE) {
                    }
                }
                Log.d(TAG, "Error during playback");
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopped = true;
    }

    // Helper method to read the input stream into a byte array
    private byte[] toByteArray(InputStream is) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        try {
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }
}
