package sample.github.nisrulz.usingrealmdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;
import sample.github.nisrulz.usingrealmdb.models.Tasks;

public class MainActivity extends AppCompatActivity {


    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        Tasks tasks = realm.createObject(Tasks.class);
        tasks.setId(UUID.randomUUID().toString());
        tasks.setDescription("Hello World!");
        tasks.setTitle("NewDay");

        realm.commitTransaction();

        RealmResults<Tasks> tasksRealmResults = realm.allObjects(Tasks.class)
                .where().contains("title", "NewDay").findAll();

        for (Tasks t : tasksRealmResults) {
            Log.d("Realm", String.format("ID : %s , Title : %s, Description : %s", t.getId(), t
                    .getTitle(), t.getDescription()));
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // very IMPORTANT
        realm.close();
    }
}
