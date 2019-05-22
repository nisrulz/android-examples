package nisrulz.github.sample.usingroomorm;

import androidx.room.Room;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

  AppDatabase db;

  Executor executor;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Create the db
    db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "people-db").build();
    executor = Executors.newSingleThreadExecutor();

    // Insert some dummy data
    for (int i = 0; i < 10; i++) {
      final Person person = new Person();
      person.setName("Person-" + i);
      person.setAge(18 + i);
      person.setAddress("Address-" + i);

      // Donot run db operations on the main thread
      // Using the executor service to run it off the main thread
      executor.execute(new Runnable() {
        public void run() {
          db.getPersonDao().insertAll(person);
        }
      });
    }

    // Retrieve the data from db

    // Donot run db operations on the main thread
    // Using the executor service to run it off the main thread
    executor.execute(new Runnable() {
      public void run() {
        List<Person> everyone = db.getPersonDao().getAllPeople();

        for (int i = 0; i < everyone.size(); i++) {
          StringBuilder stringBuilder = new StringBuilder().append(">> Row ")
              .append(i)
              .append(" : ")
              .append("UID-")
              .append(everyone.get(i).getUid())
              .append(", ")
              .append(everyone.get(i).getName())
              .append(", ")
              .append(everyone.get(i).getAddress())
              .append(", ")
              .append(everyone.get(i).getAge());

          System.out.println(stringBuilder.toString());
        }
      }
    });
  }
}
