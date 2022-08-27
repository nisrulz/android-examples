package github.nisrulz.example.radiobutton

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.radiobutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            // Initialize Radio Group and attach click handler
            radioGroup.clearCheck()
            radioGroup.setOnCheckedChangeListener { radioGroup, checkedId ->
                val rb = radioGroup.findViewById<View>(checkedId) as RadioButton?
                if (checkedId > -1 && rb != null) {
                    makeToast("Selected: ${rb.text}")
                }
            }

        }
    }

    private fun makeToast(str: String) = Toast.makeText(this, str, Toast.LENGTH_SHORT).show()

    // Function name assigned in XML
    fun onClear(v: View?) {
        // Clears all selected radio buttons to default
        binding.radioGroup.clearCheck()
        makeToast("Cleared all selection")
    }

    // Function name assigned in XML
    // Function signature requires v:View? as argument
    fun onSubmit(v: View?) {
        with(binding) {
            val checkedBtnId = radioGroup.checkedRadioButtonId
            val rb = radioGroup.findViewById<View>(checkedBtnId) as RadioButton?
            if (rb != null) {
                makeToast("Submitting: ${rb.text}")
            }
        }
    }
}