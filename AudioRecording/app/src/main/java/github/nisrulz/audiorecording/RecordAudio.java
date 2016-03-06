package github.nisrulz.audiorecording;


import android.media.MediaRecorder;
import android.util.Log;

import java.io.IOException;

public class RecordAudio {
    private final String LOGTAG = getClass().getSimpleName().toString();
    MediaRecorder mRecorder = null;
    private boolean isRecording = false;

    void releaseMediaRecorder() {
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
            Log.i(LOGTAG, "Recorder Released");
        }
        isRecording = false;
    }

    void startRecording(String mFileName) {
        if (!isRecording) {
            mRecorder = new MediaRecorder();
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setOutputFile(mFileName);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

            try {
                mRecorder.prepare();
            } catch (IOException e) {
                Log.e(LOGTAG, "prepare() failed");
            }

            mRecorder.start();
            Log.i(LOGTAG, "Recording Started");
            isRecording = true;
        }
    }

    void stopRecording() {
        try {
            if (mRecorder != null) {
                mRecorder.stop();
                Log.i(LOGTAG, "Recording Stopped");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mRecorder != null)
                mRecorder.reset();
            releaseMediaRecorder();
        }
    }

    boolean isRecording() {
        return isRecording;
    }
}
