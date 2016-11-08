package github.nisrulz.sample.chromecustomtabs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Launch Custom Chrome Tab ?", Snackbar.LENGTH_LONG)
            .setAction("Yes", new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                // TODO: 11/8/16 Open Custom Chrome Tabs
              }
            })
            .show();
      }
    });
  }
}
