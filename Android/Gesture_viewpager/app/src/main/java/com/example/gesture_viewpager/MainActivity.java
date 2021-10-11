package com.example.gesture_viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    CustomViewPagerAdapter myAdapter;

    public static GestureDetector mGestureDetector;
    public static CustomGestureListener customGestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customGestureListener = new CustomGestureListener(null);

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
            return false;
        });


    }





}