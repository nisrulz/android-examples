package nisrulz.github.sample.usingrxjava2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    basicRxJava2Example();

  }


  void basicRxJava2Example(){
    // 1. Create an Observable
    Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
      @Override
      public void subscribe(ObservableEmitter<Integer> e) throws Exception {
        //Use onNext to emit each item in the stream//
        e.onNext(1);
        e.onNext(2);
        e.onNext(3);
        e.onNext(4);

        //Once the Observable has emitted all items in the sequence, call onComplete//
        e.onComplete();
      }
    });

    // 2. Create an Observer
    Observer<Integer> observer= new Observer<Integer>() {
      @Override
      public void onSubscribe(Disposable d) {
        Log.i(TAG, "onSubscribe: ");
      }

      @Override
      public void onNext(Integer value) {
        Log.i(TAG, "onNext: " + value);
      }

      @Override
      public void onError(Throwable e) {
        Log.i(TAG, "onError: ");
      }

      @Override
      public void onComplete() {
        Log.i(TAG, "onComplete: All Done!");
      }
    };

    //3. Create our subscription i.e Subscribe Observable to Observer
    observable.subscribe(observer);
  }
}
