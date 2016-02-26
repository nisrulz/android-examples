package github.nisrulz.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * @author Nishant Srivastava
 * @project Intents
 * @company Excogitation
 * @package github.nisrulz.intents
 * @date 26/Feb/2016
 */

public class Main2Activity extends AppCompatActivity {

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

