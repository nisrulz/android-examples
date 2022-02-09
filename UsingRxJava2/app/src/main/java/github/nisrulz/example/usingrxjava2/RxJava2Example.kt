package github.nisrulz.example.usingrxjava2

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

fun basicRxJava2Example(logTag: String) {
    // 1. Create an Observable
    val observable =
        Observable.create<Int> { e -> //Use onNext to emit each item in the stream//
            e.onNext(1)
            e.onNext(2)
            e.onNext(3)
            e.onNext(4)

            //Once the Observable has emitted all items in the sequence, call onComplete//
            e.onComplete()
        }

    // 2. Create an Observer
    val observer: Observer<Int> = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            Log.i(logTag, "onSubscribe: ")
        }

        override fun onNext(value: Int) {
            Log.i(logTag, "onNext: $value")
        }

        override fun onError(e: Throwable) {
            Log.i(logTag, "onError: ")
        }

        override fun onComplete() {
            Log.i(logTag, "onComplete: All Done!")
        }
    }

    //3. Create our subscription i.e Subscribe Observable to Observer
    observable.subscribe(observer)
}

fun commonRxJava2Example(logTag: String, observable: Observable<*>) {
    // 2. Create an Observer
    val observer: Observer<Any> = object : Observer<Any> {
        override fun onSubscribe(d: Disposable) {
            Log.i(logTag, "onSubscribe: ")
        }

        override fun onNext(value: Any) {
            Log.i(logTag, "onNext: $value")
        }

        override fun onError(e: Throwable) {
            Log.i(logTag, "onError: ")
        }

        override fun onComplete() {
            Log.i(logTag, "onComplete: All Done!")
        }
    }

    //3. Create our subscription i.e Subscribe Observable to Observer
    observable.subscribe(observer)
}

fun setupExamples(logTag: String) {
    // Basic Example
    basicRxJava2Example(logTag)

    // Creating Observable using just
    Log.i(logTag, "Creating Observable using just")
    commonRxJava2Example(logTag, Observable.just("Hello World"))

    // Creating Observable using range
    Log.i(logTag, "Creating Observable using range")
    commonRxJava2Example(logTag, Observable.range(0, 5))

    // Creating Observable using from
    Log.i(logTag, "Creating Observable using fromArray")
    commonRxJava2Example(logTag, Observable.fromArray("H", "e", "l", "l", "o"))

    // Creating Observable using interval
    Log.i(logTag, "Creating Observable using interval")
    commonRxJava2Example(logTag, Observable.interval(2, TimeUnit.SECONDS))
}

