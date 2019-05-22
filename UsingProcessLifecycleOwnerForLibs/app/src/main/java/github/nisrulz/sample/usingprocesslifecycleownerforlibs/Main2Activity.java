package github.nisrulz.sample.usingprocesslifecycleownerforlibs;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.txt_2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        });
    }
}
