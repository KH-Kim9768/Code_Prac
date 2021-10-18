package com.example.gesture_viewpager;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.viewpager2.widget.ViewPager2;

public class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {

    public static TextView textView;
    static String nowAction;

    static ViewPager2 viewPager;

    boolean flagScroll;
    public static boolean isScrollStart;

    static boolean isDistanceXOver50;
    static float distX;

    static float absDistanceX;


    public CustomGestureListener(){
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
            LogManager.sendLog();

        }
    }



    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        absDistanceX = Math.abs(distanceX);

        // 스크롤이 끝났는지 여부 끝났으면 return false 하는 듯
        boolean result = super.onScroll(e1, e2, distanceX, distanceY);

        isScrollStart = true;
        this.distX = distanceX;

        if (absDistanceX > 50){
            nowAction = "distance X > 50 => " + distanceX;
            textView.setText(nowAction);
            textView.append(" ::: action = " + e1.getAction() + " ::: " + e2.getAction() + "");
            textView.append("\n ::: result = " + result);}

        return result;
    }

    public static void onScrollEnd() {
        if (viewPager.getCurrentItem() == 1 && isScrollStart && isDistanceXOver50){

            // NEXT
            if (distX >= 0){
                LogManager.setJsonToView(LogManager.MODE_NEXT);
            } else if (distX < 0){
                LogManager.setJsonToView(LogManager.MODE_PREV);
            }

        }
    }

}
