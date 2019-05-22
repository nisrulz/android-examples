package sample.github.nisrulz.interprocessservice;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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
            public void onClick(View v) {
                Intent i = new Intent(Util.SERVICE_ACTION);
                i.putExtra("value", "Data sent from App2");

                i = Util.createExplicitFromImplicitIntent(MainActivity.this, i);
                try {
                    startService(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
