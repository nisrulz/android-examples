package github.nisrulz.example.usingpocketsphinxforvoicerecognition

import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.util.Log
import edu.cmu.pocketsphinx.SpeechRecognizer as PocketSpeechRecognizer

class GoogleRecognitionListener(
    private val pocketSphinxRecognizer: PocketSpeechRecognizer,
    private val onResultListener: OnResultListener,
    private val searchKeyword: String,
) : RecognitionListener {
    private val TAG = GoogleRecognitionListener::class.java.simpleName

    override fun onBeginningOfSpeech() {}
    override fun onEndOfSpeech() {}
    override fun onReadyForSpeech(params: Bundle) {}
    override fun onRmsChanged(rmsdB: Float) {}
    override fun onBufferReceived(buffer: ByteArray) {}
    override fun onError(error: Int) {
        Log.e(TAG, "onError:$error")
        pocketSphinxRecognizer.startListening(searchKeyword)
    }

    override fun onPartialResults(partialResults: Bundle) {}
    override fun onResults(results: Bundle) {
        if (results.containsKey(SpeechRecognizer.RESULTS_RECOGNITION)) {
            val heard =
                results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) ?: arrayListOf()
            val scores = results.getFloatArray(SpeechRecognizer.CONFIDENCE_SCORES)

            for (i in heard.indices) {
                val confidence = scores?.get(i) ?: 0f
                val onResultHeardWord = heard[i]
                Log.d(TAG, "onResultHeard: $onResultHeardWord confidence: $confidence")
            }

            //send list of words to activity
            onResultListener.onResult(heard)
        }
        pocketSphinxRecognizer.startListening(searchKeyword)
    }

    override fun onEvent(eventType: Int, params: Bundle) {}
}