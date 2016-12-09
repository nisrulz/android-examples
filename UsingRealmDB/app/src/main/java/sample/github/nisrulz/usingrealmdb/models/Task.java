package sample.github.nisrulz.usingrealmdb.models;

import io.realm.RealmObject;

public class Task extends RealmObject {

  private int id;
  private String description;

  // NOTE : Donot put logic in any of the getters and setters as realm makes them useless and
  // would be ignored
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
