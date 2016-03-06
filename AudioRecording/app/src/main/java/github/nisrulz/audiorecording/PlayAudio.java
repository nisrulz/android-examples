package github.nisrulz.audiorecording;

import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;


public class PlayAudio {
    private final String LOGTAG = getClass().getSimpleName().toString();
    private boolean isPlaying = false;
    MediaPlayer mPlayer = null;

    void releaseMedidaPalyer() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
            Log.i(LOGTAG, "Audio Player Released");
        }
    }

    void startPlaying(String mFileName) {
        if (!isPlaying) {
            mPlayer = new MediaPlayer();
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlaying();
                    isPlaying = false;

                }
            });
            try {
                mPlayer.setDataSource(mFileName);
                mPlayer.prepare();
                if (!mPlayer.isPlaying())
                    mPlayer.start();
                Log.i(LOGTAG, "Audio Player Started");
            } catch (IOException e) {
                Log.e(LOGTAG, "prepare() failed");
            }

            isPlaying = true;

        }
    }

    void stopPlaying() {
        mPlayer.stop();
        mPlayer.reset();
        Log.i(LOGTAG, "Audio Player Stopped");
        releaseMedidaPalyer();
        isPlaying = false;
    }

    boolean isPlaying() {
        return isPlaying;
    }
}
