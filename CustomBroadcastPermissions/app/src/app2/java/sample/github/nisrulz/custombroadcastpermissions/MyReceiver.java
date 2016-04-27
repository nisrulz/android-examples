package sample.github.nisrulz.custombroadcastpermissions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent!=null && intent.getAction().equals("com.abc.mydata")){
            Log.d("App2","From App2 Receiver : " +intent.getStringExtra("data"));
            Toast.makeText(context,"From App2 Receiver : " +intent.getStringExtra("data"),Toast.LENGTH_LONG).show();
        }
    }
}
