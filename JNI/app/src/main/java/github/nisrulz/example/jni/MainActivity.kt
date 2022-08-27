package github.nisrulz.example.jni

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.jni.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            // Call the method as you would normally
            val message = NativeLib.msgFromJni()
            // Set in textview
            jniMsgView.text = message
        }
    }

    companion object {

    }
}