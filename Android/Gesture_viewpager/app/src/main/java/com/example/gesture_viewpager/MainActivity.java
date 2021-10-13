package com.example.gesture_viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    CustomViewPagerAdapter myAdapter;

    String dummyJson = "[{'name':'배트맨','age':43,'address':'고담'},"+
            "{'name':'슈퍼맨','age':36,'address':'뉴욕'},"+
            "{'name':'앤트맨','age':25,'address':'LA'}, " +
            "{'name':'김광희','age':25,'address':'Seoul'}]";

    public static GestureDetector mGestureDetector;
    public static CustomGestureListener customGestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customGestureListener = new CustomGestureListener();

        // GestureListener
        mGestureDetector = new GestureDetector(this, customGestureListener);


        // viewPager2
        viewPager2 = findViewById(R.id.main_viewpager);

        myAdapter = new CustomViewPagerAdapter(this);
        viewPager2.setAdapter(myAdapter);

        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        customGestureListener.setViewPager(viewPager2);

        // 제스쳐 이벤트 등록
        viewPager2.getChildAt(0).setOnTouchListener((view, motionEvent) -> {
            mGestureDetector.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == MotionEvent.ACTION_UP){ // 스크롤 끝날때 실행

                CustomGestureListener.isDistanceXOver50 = (Math.abs(CustomGestureListener.distX) > 20? true : false);
                CustomGestureListener.onScrollEnd();
                CustomGestureListener.textView.append(" ::: onScrollEnd() called");

                CustomGestureListener.isScrollStart = false;
            }
            return false;
        });




    }


}