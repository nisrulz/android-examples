package nisrulz.github.sample.usingroomorm;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Person {

  @PrimaryKey(autoGenerate = true) int uid;

  String name;
  int age;
  String address;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }
}
