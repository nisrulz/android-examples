package github.nisrulz.sample.basicmvp;

/**
 * The type User.
 */
public class User {
  private String fullName;
  private String email;

  /**
   * Sets email.
   *
   * @param email
   *     the email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Sets full name.
   *
   * @param fullName
   *     the full name
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  @Override
  public String toString() {
    return fullName + "\n" + email;
  }
}
