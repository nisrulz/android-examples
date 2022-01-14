package github.nisrulz.example.audiorecording

import android.media.MediaRecorder
import android.util.Log
import java.io.IOException

class RecordAudio {
    private val LOGTAG = javaClass.simpleName
    private var mediaRecorder: MediaRecorder? = null
    private var isRecording = false

    fun startRecording(recorder: MediaRecorder, mFileName: String) {
        if (!isRecording) {
            recorder.apply {
                mediaRecorder = recorder
                setAudioSource(MediaRecorder.AudioSource.VOICE_RECOGNITION)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setOutputFile(mFileName)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                try {
                    prepare()
                } catch (e: IOException) {
                    Log.e(LOGTAG, "prepare() failed")
                }
                start()
                Log.i(LOGTAG, "Recording Started")
                isRecording = true
            }
        }
    }

    fun stopRecording() {
        try {
            mediaRecorder?.stop()
            Log.i(LOGTAG, "Recording Stopped")
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            mediaRecorder?.reset()
            releaseMediaRecorder()
        }
    }

    fun releaseMediaRecorder() {
        mediaRecorder?.release()
        mediaRecorder = null
        Log.i(LOGTAG, "Recorder Released")

        isRecording = false
    }
}