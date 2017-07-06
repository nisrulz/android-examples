package nisrulz.github.sample.usingroomorm;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Person {
  @PrimaryKey String name;
  int age;
  String address;
}
