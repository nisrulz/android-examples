package github.nisrulz.example.customonboardingintro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.example.customonboardingintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)


            viewpager.let {
                // Set an Adapter on the ViewPager
                it.adapter = IntroAdapter(supportFragmentManager)

                // Set a PageTransformer
                it.setPageTransformer(false, IntroPageTransformer())
            }
        }
    }
}