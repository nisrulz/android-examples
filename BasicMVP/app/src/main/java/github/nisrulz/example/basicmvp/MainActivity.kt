package github.nisrulz.example.basicmvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.basicmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MvpView {

    private lateinit var binding: ActivityMainBinding

    private val mvpPresenter: MvpPresenter by lazy { MvpPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)

            btnSubmit.setOnClickListener {
                val email = edtxName.text.toString()
                val name = edtxEmail.text.toString()
                mvpPresenter.updateUserInfo(name, email)
            }
        }
    }

    override fun updateUserInfoTextView(info: String?) {
        binding.txtUserinfo.text = info
    }
}