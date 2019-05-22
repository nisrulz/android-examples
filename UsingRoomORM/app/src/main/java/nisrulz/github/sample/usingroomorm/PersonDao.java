package nisrulz.github.sample.usingroomorm;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PersonDao {

  // Adds a person to the database
  @Insert
  void insertAll(Person... people);

  // Removes a person from the database
  @Delete
  void delete(Person person);

  // Gets all people in the database
  @Query("SELECT * FROM person")
  List<Person> getAllPeople();

  // Gets all people in the database with a address
  @Query("SELECT * FROM person WHERE address LIKE :address")
  List<Person> getAllPeopleWithAddress(String address);
}
