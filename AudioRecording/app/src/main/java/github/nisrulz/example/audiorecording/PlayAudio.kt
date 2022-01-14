package github.nisrulz.example.audiorecording

import android.media.MediaPlayer
import android.util.Log
import java.io.IOException

class PlayAudio {
    private val LOGTAG = javaClass.simpleName.toString()
    var isPlayingAudio = false
        private set
    var mediaPlayer: MediaPlayer? = null

    fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
        Log.i(LOGTAG, "Audio Player Released")
    }

    fun startPlaying(mFileName: String?) {
        if (!isPlayingAudio) {
            mediaPlayer = MediaPlayer()
            mediaPlayer?.apply {
                setOnCompletionListener {
                    stopPlaying()
                    isPlayingAudio = false
                }
                try {
                    setDataSource(mFileName)
                    prepare()
                    if (!isPlaying) start()
                    Log.i(LOGTAG, "Audio Player Started")
                } catch (e: IOException) {
                    Log.e(LOGTAG, "prepare() failed")
                }
                isPlayingAudio = true
            }
        }
    }

    fun stopPlaying() {
        mediaPlayer?.stop()
        mediaPlayer?.reset()
        Log.i(LOGTAG, "Audio Player Stopped")
        releaseMediaPlayer()
        isPlayingAudio = false
    }
}