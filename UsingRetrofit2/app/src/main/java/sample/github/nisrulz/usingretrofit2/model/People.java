package sample.github.nisrulz.usingretrofit2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class People {

  @SerializedName("name") @Expose private String name;
  @SerializedName("height") @Expose private String height;
  @SerializedName("mass") @Expose private String mass;
  @SerializedName("hair_color") @Expose private String hairColor;
  @SerializedName("skin_color") @Expose private String skinColor;
  @SerializedName("eye_color") @Expose private String eyeColor;
  @SerializedName("birth_year") @Expose private String birthYear;
  @SerializedName("gender") @Expose private String gender;

  public People(String birthYear, String eyeColor, String gender, String hairColor, String height,
      String mass, String name, String skinColor, String url) {
    this.birthYear = birthYear;
    this.eyeColor = eyeColor;
    this.gender = gender;
    this.hairColor = hairColor;
    this.height = height;
    this.mass = mass;
    this.name = name;
    this.skinColor = skinColor;
  }

  /**
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name The name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return The height
   */
  public String getHeight() {
    return height;
  }

  /**
   * @param height The height
   */
  public void setHeight(String height) {
    this.height = height;
  }

  /**
   * @return The mass
   */
  public String getMass() {
    return mass;
  }

  /**
   * @param mass The mass
   */
  public void setMass(String mass) {
    this.mass = mass;
  }

  /**
   * @return The hairColor
   */
  public String getHairColor() {
    return hairColor;
  }

  /**
   * @param hairColor The hair_color
   */
  public void setHairColor(String hairColor) {
    this.hairColor = hairColor;
  }

  /**
   * @return The skinColor
   */
  public String getSkinColor() {
    return skinColor;
  }

  /**
   * @param skinColor The skin_color
   */
  public void setSkinColor(String skinColor) {
    this.skinColor = skinColor;
  }

  /**
   * @return The eyeColor
   */
  public String getEyeColor() {
    return eyeColor;
  }

  /**
   * @param eyeColor The eye_color
   */
  public void setEyeColor(String eyeColor) {
    this.eyeColor = eyeColor;
  }

  /**
   * @return The birthYear
   */
  public String getBirthYear() {
    return birthYear;
  }

  /**
   * @param birthYear The birth_year
   */
  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  /**
   * @return The gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * @param gender The gender
   */
  public void setGender(String gender) {
    this.gender = gender;
  }
}