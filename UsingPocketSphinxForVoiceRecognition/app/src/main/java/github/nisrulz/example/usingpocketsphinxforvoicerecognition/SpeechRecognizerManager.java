package github.nisrulz.example.usingpocketsphinxforvoicerecognition;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import edu.cmu.pocketsphinx.Assets;
import edu.cmu.pocketsphinx.Hypothesis;
import edu.cmu.pocketsphinx.SpeechRecognizer;
import edu.cmu.pocketsphinx.SpeechRecognizerSetup;

import static edu.cmu.pocketsphinx.SpeechRecognizerSetup.defaultSetup;

public class SpeechRecognizerManager {

    /* Named searches allow to quickly reconfigure the decoder */
    private static final String KWS_SEARCH = "wakeup";
    /* Keyword we are looking for to activate menu */
    private static String HOTWORD;
    private SpeechRecognizer mPocketSphinxRecognizer;
    private static final String TAG = SpeechRecognizerManager.class.getSimpleName();
    protected Intent mSpeechRecognizerIntent;
    protected android.speech.SpeechRecognizer mGoogleSpeechRecognizer;
    private Context mContext;

    OnResultListener onResultListener;

    public SpeechRecognizerManager(Context context) {
        this.mContext = context;
        HOTWORD = context.getResources().getString(R.string.hotword);
        initPockerSphinx();
        initGoogleSpeechRecognizer();

    }

    public void setOnResultListener(OnResultListener onResultListener) {
        this.onResultListener = onResultListener;
    }

    private void initPockerSphinx() {

        new AsyncTask<Void, Void, Exception>() {
            @Override
            protected Exception doInBackground(Void... params) {
                try {
                    Assets assets = new Assets(mContext);

                    //Performs the synchronization of assets in the application and external storage
                    File assetDir = assets.syncAssets();

                    //Creates a new SpeechRecognizer builder with a default configuration
                    SpeechRecognizerSetup speechRecognizerSetup = defaultSetup();

                    //Set Dictionary and Acoustic Model files
                    speechRecognizerSetup.setAcousticModel(new File(assetDir, "en-us-ptm"));
                    speechRecognizerSetup.setDictionary(new File(assetDir, "cmudict-en-us.dict"));

                    // Threshold to tune for keyphrase to balance between false positives and false negatives
                    speechRecognizerSetup.setKeywordThreshold(1e-45f);

                    //Creates a new SpeechRecognizer object based on previous set up.
                    mPocketSphinxRecognizer = speechRecognizerSetup.getRecognizer();

                    mPocketSphinxRecognizer.addListener(new PocketSphinxRecognitionListener());

                    // Create keyword-activation search.
                    mPocketSphinxRecognizer.addKeyphraseSearch(KWS_SEARCH, HOTWORD);
                } catch (IOException e) {
                    return e;
                }
                return null;
            }

            @Override
            protected void onPostExecute(Exception result) {
                if (result != null) {
                    Toast.makeText(mContext, "Failed to init mPocketSphinxRecognizer ", Toast.LENGTH_SHORT).show();
                } else {
                    restartSearch(KWS_SEARCH);
                }
            }
        }.execute();

    }

    private void initGoogleSpeechRecognizer() {

        mGoogleSpeechRecognizer = android.speech.SpeechRecognizer
                .createSpeechRecognizer(mContext);

        mGoogleSpeechRecognizer.setRecognitionListener(new GoogleRecognitionListener());

        mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_CONFIDENCE_SCORES, true);
    }


    public void destroy() {
        if (mPocketSphinxRecognizer != null) {
            mPocketSphinxRecognizer.cancel();
            mPocketSphinxRecognizer.shutdown();
            mPocketSphinxRecognizer = null;
        }


        if (mGoogleSpeechRecognizer != null) {
            mGoogleSpeechRecognizer.cancel();
            ;
            mGoogleSpeechRecognizer.destroy();
            mPocketSphinxRecognizer = null;
        }

    }

    private void restartSearch(String searchName) {
        mPocketSphinxRecognizer.stop();
        mPocketSphinxRecognizer.startListening(searchName);

    }


    protected class PocketSphinxRecognitionListener implements edu.cmu.pocketsphinx.RecognitionListener {
        @Override
        public void onBeginningOfSpeech() {
        }


        /**
         * In partial result we get quick updates about current hypothesis. In
         * keyword spotting mode we can react here, in other modes we need to wait
         * for final result in onResult.
         */
        @Override
        public void onPartialResult(Hypothesis hypothesis) {
            if (hypothesis == null) {
                return;
            }


            String text = hypothesis.getHypstr();
            Log.d(TAG, text);
            if (text.contains(HOTWORD)) {
                mPocketSphinxRecognizer.cancel();
                mGoogleSpeechRecognizer.startListening(mSpeechRecognizerIntent);
                Toast.makeText(mContext, "You said: " + text, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onResult(Hypothesis hypothesis) {
        }


        /**
         * We stop mPocketSphinxRecognizer here to get a final result
         */
        @Override
        public void onEndOfSpeech() {

        }

        public void onError(Exception error) {
        }

        @Override
        public void onTimeout() {
        }

    }


    protected class GoogleRecognitionListener implements
            android.speech.RecognitionListener {

        private final String TAG = GoogleRecognitionListener.class
                .getSimpleName();

        @Override
        public void onBeginningOfSpeech() {
        }

        @Override
        public void onEndOfSpeech() {
        }

        @Override
        public void onReadyForSpeech(Bundle params) {
        }

        @Override
        public void onRmsChanged(float rmsdB) {
        }

        @Override
        public void onBufferReceived(byte[] buffer) {

        }

        @Override
        public void onError(int error) {
            Log.e(TAG, "onError:" + error);
            mPocketSphinxRecognizer.startListening(KWS_SEARCH);


        }

        @Override
        public void onPartialResults(Bundle partialResults) {
        }

        @Override
        public void onResults(Bundle results) {
            if ((results != null)
                    && results.containsKey(android.speech.SpeechRecognizer.RESULTS_RECOGNITION)) {

                ArrayList<String> heard = results
                        .getStringArrayList(android.speech.SpeechRecognizer.RESULTS_RECOGNITION);
                float[] scores = results
                        .getFloatArray(android.speech.SpeechRecognizer.CONFIDENCE_SCORES);

                for (int i = 0; i < heard.size(); i++) {
                    Log.d(TAG, "onResultsheard:" + heard.get(i)
                            + " confidence:" + scores[i]);
                }


                //send list of words to activity
                onResultListener.OnResult(heard);
            }

            mPocketSphinxRecognizer.startListening(KWS_SEARCH);
        }


        @Override
        public void onEvent(int eventType, Bundle params) {
        }
    }


    public interface OnResultListener {
        void OnResult(ArrayList<String> commands);
    }

}
