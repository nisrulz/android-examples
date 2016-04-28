package sample.github.nisrulz.interprocessservice;

import android.app.IntentService;
import android.content.Intent;

public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (Util.SERVICE_ACTION.equals(action)) {
                String value = intent.getStringExtra("value");

                LogHelper.log(getClass().getSimpleName() + " - " + "onHandleIntent", value);
            }

        }
    }

}
