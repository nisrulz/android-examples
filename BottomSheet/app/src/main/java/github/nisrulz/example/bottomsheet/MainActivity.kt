package github.nisrulz.example.bottomsheet

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import github.nisrulz.example.bottomsheet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            setupBottomSheet(this)
        }
    }


    private fun setupBottomSheet(binding: ActivityMainBinding) {
        BottomSheetBehavior.from(binding.bottomSheet).apply {
            // Set it as collapsed initially
            state = BottomSheetBehavior.STATE_COLLAPSED
            binding.btnOpenBtmSheet.setOnClickListener { // Expand
                setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            binding.btnCollapseBtmSheet.setOnClickListener { // Collapse
                setState(BottomSheetBehavior.STATE_COLLAPSED)
            }
            binding.btnPeekBtmSheet.setOnClickListener { // Peek
                setPeekHeight(400, true)
            }

            // Make peeking gone when completely collapsed
            addBottomSheetCallback(object : BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                        setPeekHeight(0, true)
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            })
        }
    }
}