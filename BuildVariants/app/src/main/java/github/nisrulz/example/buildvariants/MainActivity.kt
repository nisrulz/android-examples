package github.nisrulz.example.buildvariants

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.buildvariants.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            val information = buildString {
                append("\n\n")
                append(Info.typeOfBuild)
                append("\n\n")
                append("Package Name :")
                append("\n")
                append(packageName)
                append("\n\n")
                append("Is Debuggable : ")
                append("\n")
                append(DebugInfo.isDebuggable)
            }

            textView.text = information

            Logger.logd("This is Debug Message")
            Logger.loge(RuntimeException("This is Exception Message"))
        }
    }
}