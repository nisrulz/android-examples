package github.nisrulz.firebase;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
  TextView txt;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    txt = (TextView) findViewById(R.id.text);

    final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        // On Click
        // Write data to Firebase Database
        rootRef.child("message").setValue("Do you have data? You'll love Firebase.");
      }
    });

    // Read data from Firebase Database
    rootRef.child("message").addValueEventListener(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
        System.out.println(
            dataSnapshot.getValue());  //prints "Do you have data? You'll love Firebase."
        txt.setText(dataSnapshot.getValue().toString());
      }

      @Override public void onCancelled(DatabaseError databaseError) {

      }
    });
  }
}
