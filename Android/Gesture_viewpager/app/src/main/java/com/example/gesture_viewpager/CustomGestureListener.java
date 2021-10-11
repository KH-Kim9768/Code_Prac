package com.example.gesture_viewpager;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.viewpager2.widget.ViewPager2;

public class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {

    TextView textView;
    String nowAction;

    ViewPager2 viewPager;

    public CustomGestureListener(TextView textView){
        this.textView = textView;

    }


    public void setTextView(TextView textView){

        this.textView = textView;

    }

    public void setViewPager(ViewPager2 viewPager){
        this.viewPager = viewPager;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        if (viewPager.getCurrentItem() == 1){
            nowAction = "LongPress";
            textView.setText(nowAction);
        }
    }


    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            nowAction = "e1 = " + e1.toString() + ", e2 = " + e2.toString();

        float absDistanceX = Math.abs(distanceX);

        if (viewPager.getCurrentItem() == 1){
            if (absDistanceX > 50){
                nowAction = "distance X > 50 => " + distanceX;
                textView.setText(nowAction);
            }
        }


        return true;
    }
}
