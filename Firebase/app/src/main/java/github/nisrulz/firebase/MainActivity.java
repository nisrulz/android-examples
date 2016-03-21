package github.nisrulz.firebase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    // Declare the Firebase instance
    Firebase myFirebaseRef;

    // ----------- IMPORTANT ----------
    // Feed the appropiate url of your firebase app here, or else the app wont run.
    String firebaseURL = "https://<YOUR-FIREBASE-APP>.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt = (TextView) findViewById(R.id.text);

        // Set the context for Firebase
        Firebase.setAndroidContext(this);

        // Init the firebase instance
        myFirebaseRef = new Firebase(firebaseURL);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // On Click
                // Write data to Firebase Database
                myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");
            }
        });

        // Read data from Firebase Database
        myFirebaseRef.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
                txt.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError error) {
            }
        });
    }
}
