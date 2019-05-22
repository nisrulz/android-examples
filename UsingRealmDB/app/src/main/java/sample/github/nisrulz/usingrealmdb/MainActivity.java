package sample.github.nisrulz.usingrealmdb;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import io.realm.Realm;
import io.realm.RealmResults;
import sample.github.nisrulz.usingrealmdb.models.Task;

public class MainActivity extends AppCompatActivity {

  private Realm realm;

  Button add, view, update, delete;
  EditText description, id;
  TextView text;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Setup view references
    add = (Button) findViewById(R.id.add);
    view = (Button) findViewById(R.id.view);
    update = (Button) findViewById(R.id.update);
    delete = (Button) findViewById(R.id.delete);
    description = (EditText) findViewById(R.id.desc);
    id = (EditText) findViewById(R.id.id);
    text = (TextView) findViewById(R.id.text);

    // Get the default realm instance
    realm = Realm.getDefaultInstance();
  }

  public void clickAction(View view) {
    switch (view.getId()) {
      case R.id.add:
        addRecord();
        break;
      case R.id.view:
        viewRecord();
        break;
      case R.id.update:
        updateRecord();
        break;
      case R.id.delete:
        deleteRecord();
    }
  }

  public void addRecord() {
    realm.beginTransaction();

    Task task = realm.createObject(Task.class);
    task.setId(Integer.parseInt(id.getText().toString()));
    task.setDescription(description.getText().toString());

    realm.commitTransaction();
  }

  public void viewRecord() {
    RealmResults<Task> results = realm.where(Task.class).findAll();

    text.setText("");

    for (Task task : results) {
      text.append(task.getId() + " " + task.getDescription() + "\n");
    }
  }

  public void updateRecord() {
    RealmResults<Task> results =
        realm.where(Task.class).equalTo("id", Integer.parseInt(id.getText().toString())).findAll();

    realm.beginTransaction();

    for (Task task : results) {
      task.setDescription(description.getText().toString());
    }

    realm.commitTransaction();
  }

  public void deleteRecord() {
    RealmResults<Task> results =
        realm.where(Task.class).equalTo("id", Integer.parseInt(id.getText().toString())).findAll();

    realm.beginTransaction();

    results.deleteAllFromRealm();

    realm.commitTransaction();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    // very IMPORTANT
    realm.close();
  }
}
