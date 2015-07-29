package com.valentine.parseloginsignup;

import android.content.Intent;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by valentine on 7/29/15.
 */
public class MyIntro extends AppIntro {
    @Override
    public void init(Bundle savedInstanceState){
        addSlide(AppIntroFragment.newInstance("slide1", getString(R.string.des1), R.drawable.icon, R.color.abc_background_cache_hint_selector_material_light));
//        addSlide(second_fragment);
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


}

