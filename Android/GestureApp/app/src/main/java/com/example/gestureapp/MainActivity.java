package com.example.gestureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String nowAction;


    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.test_textView);
        nowAction = "";

        mGestureDetector = new GestureDetector(this, testGestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    SimpleOnGestureListener testGestureListener = new SimpleOnGestureListener(){

        @Override
        public void onLongPress(MotionEvent e) {
            nowAction = "LongPress";
            textView.setText(nowAction);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            nowAction = "e1 = " + e1.toString() + ", e2 = " + e2.toString();

            float absDistanceX = Math.abs(distanceX);

            if (absDistanceX > 50){
                nowAction = "distance X > 50 => " + distanceX;
                textView.setText(nowAction);
            };

            return true;
        }


    };
}