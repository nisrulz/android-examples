package github.nisrulz.intentservice;

import android.app.IntentService;
import android.content.Intent;


public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            System.out.println(intent.getStringExtra("data"));
        }
    }
}
