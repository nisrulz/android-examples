package nisrulz.github.sample.usingroomorm;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {
    Person.class /*, AnotherEntityType.class, AThirdEntityType.class */
}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
  public abstract PersonDao getPersonDao();
}
