package github.nisrulz.circularimage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.nisrulz.circularimage.utils.setDrawableAsCircular
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1: No Library
        imageView.setDrawableAsCircular(R.drawable.puppy)

        // 2: Picasso
        //Picasso.get().load(R.drawable.puppy).transform(CropCircleTransformation()).into(imageView);

        // 3: Glide
        //Glide.with(this).load(R.drawable.puppy).transform(CircleCrop()).into(imageView);


    }
}
