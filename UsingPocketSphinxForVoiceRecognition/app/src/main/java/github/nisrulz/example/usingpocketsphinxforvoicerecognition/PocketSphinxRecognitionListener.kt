package github.nisrulz.example.usingpocketsphinxforvoicerecognition

import android.util.Log
import edu.cmu.pocketsphinx.Hypothesis
import edu.cmu.pocketsphinx.RecognitionListener
import edu.cmu.pocketsphinx.SpeechRecognizer as PocketSpeechRecognizer

class PocketSphinxRecognitionListener(
    private val pocketSphinxRecognizer: PocketSpeechRecognizer,
    private val hotWord: String,
    val onKeywordSpotted: (String) -> Unit
) : RecognitionListener {
    private val TAG = PocketSphinxRecognitionListener::class.java.simpleName

    override fun onBeginningOfSpeech() {}

    /**
     * In partial result we get quick updates about current hypothesis. In
     * keyword spotting mode we can react here, in other modes we need to wait
     * for final result in onResult.
     */
    override fun onPartialResult(hypothesis: Hypothesis) {
        val text = hypothesis.hypstr
        Log.d(TAG, text)
        if (text.contains(hotWord)) {
            pocketSphinxRecognizer.apply {
                cancel()
                startListening(text)
                onKeywordSpotted(text)
            }

        }
    }

    override fun onResult(hypothesis: Hypothesis) {}

    /**
     * We stop pocketSphinxRecognizer here to get a final result
     */
    override fun onEndOfSpeech() {}
    override fun onError(error: Exception) {}
    override fun onTimeout() {}
}