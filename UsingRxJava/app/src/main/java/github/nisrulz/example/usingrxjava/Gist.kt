package github.nisrulz.example.usingrxjava

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import rx.Observable
import java.io.IOException

val gson = Gson()
val client = OkHttpClient()

fun gist(id: String): Gist? {
    val request: Request = Request.Builder()
        .url("https://api.github.com/gists/$id")
        .build()
    val response = client.newCall(request).execute()
    return if (response.isSuccessful) {
        gson.fromJson(response.body?.charStream(), Gist::class.java)
    } else null
}

fun createGistObservable(id: String) = Observable.defer {
    Observable.just(
        try {
            gist(id)
        } catch (e: IOException) {
            Gist()
        }
    )
}