package nisrulz.github.sample.usingroomorm;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    AppDatabase db =
        Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "people-db").build();
  }
}
