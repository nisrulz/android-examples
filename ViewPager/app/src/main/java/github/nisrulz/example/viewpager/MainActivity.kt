package github.nisrulz.example.viewpager

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import github.nisrulz.example.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            setupUi(this)
        }
    }

    private fun setupUi(binding: ActivityMainBinding) {
        // Declare ViewPager
        val myVP = ViewPager(this)
        // Set ID of viewpager
        myVP.id = View.generateViewId()
        // Add ViewPager to LinearLayout Container in the activity
        binding.container.addView(myVP)
        // Set the adapter
        myVP.adapter = MyFragmentPagerAdapter(supportFragmentManager)
        // Set the on page change listener
        myVP.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "Selected page position: $position", Toast.LENGTH_SHORT
                ).show()
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        // set page transformer for animation
        myVP.setPageTransformer(false) { view, position ->
            val pageWidth = view.width
            val pageHeight = view.height
            when {
                position < -1 -> { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    view.alpha = 0f
                }
                position <= 1 -> { // Page to the left, page centered, page to the right
                    // modify page view animations here for pages in view
                }
                else -> { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    view.alpha = 0f
                }
            }
        }
    }
}