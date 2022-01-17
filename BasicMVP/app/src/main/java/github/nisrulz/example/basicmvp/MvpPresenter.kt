package github.nisrulz.example.basicmvp

class MvpPresenter(private var mvpView: MvpView) {

    fun updateUserInfo(fullName: String, email: String) {
        val updatedUser = User(fullName, email)
        mvpView.updateUserInfoTextView(updatedUser.toString())
    }
}