package sample.github.nisrulz.usingrealmdb.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Tasks extends RealmObject {

    @PrimaryKey
    private String id;
    private String title;
    private String description;



    // NOTE : Donot put logic in any of the getters and setters as realm makes them useless and
    // would be ignored
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
