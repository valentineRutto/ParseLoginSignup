package com.valentine.parseloginsignup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by valentine on 7/29/15.
 */
public class MyIntro extends AppIntro {
    @Override
    public void init(Bundle savedInstanceState){
        addSlide(AppIntroFragment.newInstance("inTOUCH", getString(R.string.des1), R.drawable.icon, R.color.abc_background_cache_hint_selector_material_light));
        addSlide(AppIntroFragment.newInstance("naVIGATION", getString(R.string.des2), R.drawable.icon, R.color.abc_background_cache_hint_selector_material_light));

// addSlide(second_fragment);
        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));
        showSkipButton(false);

        setVibrate(true);
        setVibrateIntensity(30);
    }
    private void loadMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSkipPressed() {
        loadMainActivity();

    }

    @Override
    public void onDonePressed() {
        loadMainActivity();

    }
    public void getStarted(View v){
        loadMainActivity();
    }


}

