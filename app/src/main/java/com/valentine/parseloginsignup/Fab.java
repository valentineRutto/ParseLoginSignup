package com.valentine.parseloginsignup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

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
        setTranslation(translationX, translationY);

        // Only use scale animation if FAB is hidden
        if (getVisibility() != View.VISIBLE) {
            // Pivots indicate where the animation begins from
            float pivotX = getPivotX() + translationX;
            float pivotY = getPivotY() + translationY;

            ScaleAnimation anim;
            // If pivots are 0, that means the FAB hasn't been drawn yet so just use the
            // center of the FAB
            if (pivotX == 0 || pivotY == 0) {
                anim = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
            } else {
                anim = new ScaleAnimation(0, 1, 0, 1, pivotX, pivotY);
            }

            // Animate FAB expanding
            anim.setDuration(FAB_ANIM_DURATION);
            anim.setInterpolator(getInterpolator());
            startAnimation(anim);
        }
        setVisibility(View.VISIBLE);
    }



    @Override
    public void hide() {
    }
}