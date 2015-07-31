package com.valentine.parseloginsignup;

import android.content.Context;
import android.util.AttributeSet;

import com.gordonwong.materialsheetfab.AnimatedFab;

public class Fab extends FloatingActionButton implements AnimatedFab {
    private static final int FAB_ANIM_DURATION = 200;

    public Fab(Context context) {
        super(context);
    }

    public Fab(Context context, AttributeSet attrs) {
        sup
        er(context, attrs);
    }

    public Fab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void show() {
        show(0, 0);    }

    @Override
    public void show(float translationX, float translationY) {

    }


    @Override
    public void hide() {
    }
}