package sample.github.nisrulz.custombroadcastpermissions;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction("com.abc.mydata");
                i.putExtra("data", "Data String broadcasted from MainActivity");
                sendBroadcast(i,"com.abc.permission.GET_DATA");
            }
        });
    }
}
