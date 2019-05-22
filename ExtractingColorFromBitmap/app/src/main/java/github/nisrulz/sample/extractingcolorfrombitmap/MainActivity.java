package github.nisrulz.sample.extractingcolorfrombitmap;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MainActivity extends AppCompatActivity {
  ImageView imageView;
  ViewGroup backgroundGroup;
  TextView titleColorText;
  TextView bodyColorText;
  int imageDimension;
  Button btn_reload;

  ProgressDialog progressDialog;

  final String RANDOM_IMAGE_URL = "https://unsplash.it/400/?random";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    imageView = (ImageView) findViewById(R.id.main_image);
    backgroundGroup = (ViewGroup) findViewById(R.id.main_background);
    titleColorText = (TextView) findViewById(R.id.main_title_text);
    bodyColorText = (TextView) findViewById(R.id.main_body_text);
    imageDimension = (int) getResources().getDimension(R.dimen.image_size);
    btn_reload = (Button) findViewById(R.id.btn_reload);

    progressDialog = new ProgressDialog(this);
    progressDialog.setIndeterminate(true);
    progressDialog.setCancelable(true);
    progressDialog.setMessage("Fetching from server..");

    loadRandomImage();

    btn_reload.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        loadRandomImage();
      }
    });
  }

  private void loadRandomImage() {
    Picasso.with(MainActivity.this).invalidate(RANDOM_IMAGE_URL);

    Picasso.with(MainActivity.this)
        .load(RANDOM_IMAGE_URL)
        .memoryPolicy(MemoryPolicy.NO_STORE)
        .networkPolicy(NetworkPolicy.NO_CACHE)
        .resize(imageDimension, imageDimension)
        .error(R.drawable.ic_cloud_white_24dp)
        .placeholder(R.drawable.ic_cloud_white_24dp)
        .centerCrop()
        .into(new Target() {
          @Override
          public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            assert imageView != null;
            imageView.setImageBitmap(bitmap);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
              @Override
              public void onGenerated(Palette palette) {
                Palette.Swatch darkMutedSwatch = palette.getDarkMutedSwatch();

                if (darkMutedSwatch == null) {
                  Toast.makeText(MainActivity.this, "Null swatch :(", Toast.LENGTH_SHORT).show();
                  return;
                }
                backgroundGroup.setBackgroundColor(darkMutedSwatch.getRgb());
                titleColorText.setTextColor(darkMutedSwatch.getTitleTextColor());
                bodyColorText.setTextColor(darkMutedSwatch.getBodyTextColor());
                progressDialog.cancel();
              }
            });
          }

          @Override
          public void onBitmapFailed(Drawable errorDrawable) {
            progressDialog.cancel();
          }

          @Override
          public void onPrepareLoad(Drawable placeHolderDrawable) {
            progressDialog.show();
          }
        });
  }
}
