package com.valentine.parseloginsignup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by valentine on 7/29/15.
 */
public class MyIntro extends AppIntro {
    @Override
    public void init(Bundle savedInstanceState){
        addSlide(AppIntroFragment.newInstance("inTOUCH", getString(R.string.des1), R.drawable.buttons, R.color.abc_background_cache_hint_selector_material_light));
        addSlide(AppIntroFragment.newInstance("inTOUCH", getString(R.string.des2), R.drawable.share, R.color.abc_background_cache_hint_selector_material_light));
        addSlide(AppIntroFragment.newInstance("inTOUCH", getString(R.string.des3), R.drawable.done, R.color.abc_background_cache_hint_selector_material_light));

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

            Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
        }



    @Override
    public void onDonePressed() {
        loadMainActivity();

    }

    public void getStarted(View v){
        loadMainActivity();

    }


}

