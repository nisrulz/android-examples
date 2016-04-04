package github.nisrulz.usingappintro;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class MyIntroActivity extends AppIntro2 {


    @Override
    public void init(Bundle bundle) {

        // Make it fullscreen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        String[] titles = {getResources().getString(R.string.title_1), getResources().getString(R
                .string.title_2), getResources().getString(R.string.title_3), getResources()
                .getString(R.string.title_4)};
        String[] desc = {getResources().getString(R.string.desc_1), getResources().getString(R
                .string.desc_2), getResources().getString(R.string.desc_3), getResources()
                .getString(R.string.desc_4)};

        addSlide(AppIntroFragment.newInstance(titles[0], desc[0], R.drawable.p1,
                R.color.colorPrimary));
        addSlide(AppIntroFragment.newInstance(titles[1], desc[1], R.drawable.p2,
                R.color.colorPrimary));
        addSlide(AppIntroFragment.newInstance(titles[2], desc[2], R.drawable.p3,
                R.color.colorPrimary));
        addSlide(AppIntroFragment.newInstance(titles[3], desc[3], R.drawable.p4,
                R.color.colorPrimary));

    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(MyIntroActivity.this, MainActivity.class));

    }

    @Override
    public void onSlideChanged() {

    }
}
