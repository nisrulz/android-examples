package github.nisrulz.example.usingpocketsphinxforvoicerecognition

import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer.createSpeechRecognizer
import android.widget.Toast
import edu.cmu.pocketsphinx.Assets
import edu.cmu.pocketsphinx.SpeechRecognizer
import edu.cmu.pocketsphinx.SpeechRecognizerSetup
import java.io.File

class SpeechRecognizerManager(
    private val assets: Assets,
    private val hotword: String, //Keyword we are looking for to activate menu
    private val onResultListener: OnResultListener,
) {
    private val TAG = SpeechRecognizerManager::class.java.simpleName

    // Named searches allow to quickly reconfigure the decoder
    private val KWS_SEARCH = "wakeup"

    private var speechRecognizerIntent by lazy { createSpeechRecognizer(context) }

    private lateinit var pocketSphinxRecognizer: SpeechRecognizer
    private lateinit var googleSpeechRecognizer: android.speech.SpeechRecognizer

    private suspend fun initPockerSphinx() {
        //Performs the synchronization of assets in the application and external storage
        val assetDir = assets.syncAssets()

        //Creates a new SpeechRecognizer builder with a default configuration
        val speechRecognizerSetup = SpeechRecognizerSetup.defaultSetup()

        //Set Dictionary and Acoustic Model files
        speechRecognizerSetup.setAcousticModel(File(assetDir, "en-us-ptm"))
        speechRecognizerSetup.setDictionary(File(assetDir, "cmudict-en-us.dict"))

        // Threshold to tune for keyphrase to balance between false positives and false negatives
        speechRecognizerSetup.setKeywordThreshold(1e-45f)

        //Creates a new SpeechRecognizer object based on previous set up.
        pocketSphinxRecognizer = speechRecognizerSetup.recognizer
        pocketSphinxRecognizer.addListener(PocketSphinxRecognitionListener())

        // Create keyword-activation search.
        pocketSphinxRecognizer.addKeyphraseSearch(KWS_SEARCH, HOTWORD)


        if (result != null) {
            Toast.makeText(
                context,
                "Failed to init pocketSphinxRecognizer ",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            restartSearch()
        }
    }

    private fun initGoogleSpeechRecognizer() {
        googleSpeechRecognizer
            ?.setRecognitionListener(GoogleRecognitionListener())
            .also { googleSpeechRecognizer = it }
        Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            .apply {
                putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                )
                putExtra(RecognizerIntent.EXTRA_CONFIDENCE_SCORES, true)
            }.also { speechRecognizerIntent = it }
    }

    fun destroy() {
        pocketSphinxRecognizer?.apply {
            cancel()
            shutdown()
        }

        googleSpeechRecognizer?.apply {
            cancel()
            destroy()
        }
    }

    private fun restartSearch(searchName: String = KWS_SEARCH) {
        pocketSphinxRecognizer?.apply {
            stop()
            startListening(searchName)
        }
    }

    fun init() {
        initPockerSphinx()
        initGoogleSpeechRecognizer()
    }
}