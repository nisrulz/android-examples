package github.nisrulz.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


/**
 * @author Nishant Srivastava
 * @project Intents
 * @company Excogitation
 * @package github.nisrulz.intents
 * @date 26/Feb/2016
 */

public class MainActivity extends AppCompatActivity {

    TextView textView_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        textView_1 = (TextView) findViewById(R.id.textView);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Click Ok to fire an Explicit Intent for Result", Snackbar
                        .LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                launchExplicitIntent();
                            }
                        }).show();
            }
        });
    }


    /**
     * Explicit Intent
     */
    public void launchExplicitIntent() {
        // first parameter is the context, second is the class of the activity to launch
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        POJOClass pojoClass = new POJOClass("Radix", "This is some text");
        i.putExtra("data", pojoClass);
        startActivity(i); // brings up the second activity
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
