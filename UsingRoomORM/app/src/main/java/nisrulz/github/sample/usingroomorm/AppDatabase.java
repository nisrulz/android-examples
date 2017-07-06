package nisrulz.github.sample.usingroomorm;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {
    Person.class /*, AnotherEntityType.class, AThirdEntityType.class */
}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
  public abstract PersonDao getPersonDao();
}
