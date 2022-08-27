package github.nisrulz.example.usingrxjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.usingrxjava.databinding.ActivityMainBinding
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var subscription: Subscription

    private lateinit var binding: ActivityMainBinding

    // Go get this Gist via GitHub API:
    //      https://gist.github.com/nisrulz/59d6da0a107ea0c44f4a55db6e00d9c0
    private val GIST_ID = "59d6da0a107ea0c44f4a55db6e00d9c0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            subscription = createGistObservable(GIST_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    mainMessage.text = createStringDataFromGist(it)
                }
                .subscribe()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
    }

    private fun createStringDataFromGist(gist: Gist?): String {
        val sb = StringBuilder()
        // Output
        gist?.let {
            for ((key, value) in gist.files) {
                with(sb) {
                    append(key)
                    append("\n")
                    append("Length of file ")
                    append(value.content.length)
                    append("\n-------------------\n\n")
                }
            }
        }
        return sb.toString()
    }
}