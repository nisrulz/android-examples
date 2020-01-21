package github.nisrulz.circularimage

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageDrawable = ContextCompat.getDrawable(this, R.drawable.puppy)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageView.setImageDrawable(imageDrawable)
            imageView.clipToCircle()
        } else {
            imageView.setImageDrawable(imageDrawable.circular(this))
        }
    }
}
