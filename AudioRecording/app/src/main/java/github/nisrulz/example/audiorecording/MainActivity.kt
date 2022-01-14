package github.nisrulz.example.audiorecording

import android.annotation.SuppressLint
import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.audiorecording.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var recordAudio = RecordAudio()
    private var playAudio = PlayAudio()
    private val recorder by lazy { getMediaRecorder() }

    private val recordingFileName: String by lazy {
        Environment.getExternalStorageDirectory().absolutePath + "/audiorecord.3gp"
    }

    private fun getMediaRecorder(): MediaRecorder {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            MediaRecorder(this)
        } else {
            MediaRecorder()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            setSupportActionBar(toolbar)

            txtView.text = "Press and hold record button to record"
            fabRec.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        txtView.text = "Recording Started"
                        recordAudio.startRecording(recorder, recordingFileName)
                    }
                    MotionEvent.ACTION_UP -> {
                        txtView.text = "Press and hold record button to record\nRecording Stopped"
                        recordAudio.stopRecording()
                    }
                }
                true
            }
            fabPlay.setOnClickListener {
                if (playAudio.isPlayingAudio) {
                    txtView.text = "Press and hold record button to record\nAudio play stopped"
                    playAudio.stopPlaying()
                } else {
                    txtView.text = "Audio play started"
                    playAudio.startPlaying(recordingFileName)
                }
            }

        }
    }

    public override fun onPause() {
        super.onPause()
        recordAudio.releaseMediaRecorder()
        playAudio.releaseMediaPlayer()
    }
}