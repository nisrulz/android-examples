package github.nisrulz.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author Nishant Srivastava
 * @project Intents
 * @company Excogitation
 * @package github.nisrulz.intents
 * @date 26/Feb/2016
 */

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

        // Get Parceable data from intent
        POJOClass pojoClass = getIntent().getParcelableExtra("data");

        TextView textView_2 = (TextView) findViewById(R.id.textView_2);
        String text = "Name : " + pojoClass.getName() + "\n Text : " + pojoClass.getText();
        textView_2.setText(text);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Click Ok to fire an Implicit Intent", Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                launchImplicitIntent();
                            }
                        }).show();
            }
        });


        implicitIntents = new ImplicitIntents();


        data = new ArrayList<>();
        data.add("Call a number");
        data.add("Send an email");
        data.add("Open a webpage");
        data.add("Open app page in playstore");
        data.add("Send SMS");
        data.add("Take a picture");


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
                }
            }
        });
    }

    /**
     * Implicit Intent
     */
    public void launchImplicitIntent() {
        // first parameter is the context, second is the class of the activity to launch
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(i); // brings up the second activity
    }
}

