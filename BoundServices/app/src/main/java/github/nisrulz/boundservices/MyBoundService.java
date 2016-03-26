package github.nisrulz.boundservices;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.widget.Toast;

public class MyBoundService extends Service {
    public MyBoundService() {
    }

    final Messenger myMessenger = new Messenger(new IncomingHandler());

    @Override
    public IBinder onBind(Intent intent) {
        return myMessenger.getBinder();
    }


    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Bundle data = msg.getData();
            String dataString = data.getString("data");
            String textToDisplay = "Message received in Service : " + dataString;
            Toast.makeText(getApplicationContext(),
                    textToDisplay, Toast.LENGTH_SHORT).show();
        }
    }
}
