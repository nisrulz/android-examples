package github.nisrulz.sample.usingparceler;

import org.parceler.Parcel;

import static org.parceler.Parcel.Serialization;

@Parcel(Serialization.BEAN)
class Person {
  private String name;
  private String address;
  private int age;
  private String occupation;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  @Override
  public String toString() {
    StringBuilder data = new StringBuilder();
    data.append("Name : ")
        .append(name)
        .append("\n")
        .append("Address : ")
        .append(address)
        .append("\n")
        .append("Age : ")
        .append(age)
        .append("\n")
        .append("Occupation : ")
        .append(occupation);
    return data.toString();
  }
}
