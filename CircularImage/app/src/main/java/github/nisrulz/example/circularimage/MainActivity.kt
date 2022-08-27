package github.nisrulz.example.circularimage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.squareup.picasso.Picasso
import github.nisrulz.example.circularimage.databinding.ActivityMainBinding
import github.nisrulz.example.circularimage.utils.setDrawableAsCircular
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            // 1: No Library
            imageViewCircular.setDrawableAsCircular(R.drawable.puppy)

            // 2: Picasso
            Picasso.get()
                .load(R.drawable.puppy)
                .transform(CropCircleTransformation())
                .into(imageViewPicasso)

            // 3: Glide
            Glide.with(applicationContext)
                .load(R.drawable.puppy)
                .transform(CircleCrop())
                .into(imageViewGlide);
        }

    }
}
