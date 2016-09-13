package github.nisrulz.sample.basicmvp;

/**
 * Presenter : MvpPresenter
 */
public class MvpPresenter {

  /**
   * Model : User
   */
  User user;
  /**
   * View : MvpView
   */
  MvpView mvpView;

  /**
   * Instantiates a new Main Presenter.
   *
   * @param mvpView
   *     the mvpView
   */
  public MvpPresenter(MvpView mvpView) {
    this.mvpView = mvpView;
    user = new User();
  }

  /**
   * Update full name.
   *
   * @param fullName
   *     the full name
   */
  public void updateFullName(String fullName) {
    user.setFullName(fullName);
    mvpView.updateUserInfoTextView(user.toString());
  }

  /**
   * Update email.
   *
   * @param email
   *     the email
   */
  public void updateEmail(String email) {
    user.setEmail(email);
    mvpView.updateUserInfoTextView(user.toString());
  }
}
