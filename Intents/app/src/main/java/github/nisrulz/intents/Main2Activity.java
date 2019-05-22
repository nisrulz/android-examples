package github.nisrulz.intents;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter<String> adapter;
    ArrayList<String> data;

    ImplicitIntents implicitIntents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView_2 = (TextView) findViewById(R.id.textView_2);
        data = new ArrayList<>();
        data.add("Call a number");
        data.add("Send an email");
        data.add("Open a webpage");
        data.add("Open app page in playstore");
        data.add("Send SMS");
        data.add("Take a picture");

        if (getIntent().getStringExtra("type").equals("pojo")) {
            // Get Parceable data from intent
            POJOClass pojoClass = getIntent().getParcelableExtra("data");

            String text = "Data Sent from Activity : Name=" + pojoClass.getName() + "\n Text=" + pojoClass.getText();
            textView_2.setText(text);
        } else if (getIntent().getStringExtra("type").equals("result")) {
            Bundle bundle = getIntent().getBundleExtra("bundle");
            String txt = bundle.getString("text");
            String text = "Data Sent from Activity : Text=" + txt;
            textView_2.setText(text);


            data.add("Return result to calling activity");
        }

        implicitIntents = new ImplicitIntents();

        lv = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        implicitIntents.call(Main2Activity.this, "0001112223");
                        break;
                    case 1:
                        implicitIntents.sendEmail(Main2Activity.this, new String[]{"someone@email.com"}, "subject", "body");
                        break;
                    case 2:
                        implicitIntents.openUrlInBrowser(Main2Activity.this, "http://www.google.com");
                        break;
                    case 3:
                        implicitIntents.openAppPageInPlaystore(Main2Activity.this);
                        break;
                    case 4:
                        implicitIntents.sendSMS(Main2Activity.this, "0001112223", "Hello");
                        break;
                    case 5:
                        implicitIntents.takeAPic(Main2Activity.this, "saved_img", "img_1");
                        break;
                    case 6:
                        returnResult();
                        break;
                }
            }
        });
    }

    private void returnResult() {
        Bundle bundle = new Bundle();
        bundle.putString("text", "This is the returning result from Main2Activity");

        Intent i = new Intent();
        i.putExtra("returndata", bundle);

        setResult(RESULT_OK, i);
        finish();
    }
}

