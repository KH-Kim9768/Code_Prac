package com.example.pinch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView te;
    String s;
    float d1, d2, r;
    Matrix m;
    ImageView iv;

    float getDistance(MotionEvent ev){
        float dx = ev.getX(1) - ev.getX(0);
        float dy = ev.getY(1) - ev.getY(0);

        return (float) Math.sqrt(dx*dx + dy*dy);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action;
        int index;
        action = event.getAction() & 0xff;
        index = (event.getAction() & 0xff00) >> 8;


        switch(action){
            case MotionEvent.ACTION_DOWN:
                s = "Down index = " + index + " x = " + event.getX() + " y = " + event.getY();
                te.setText(s);
                break;

            case MotionEvent.ACTION_MOVE:
                s = "Move index = " + index + " x = " + event.getX() + " y = " + event.getY();
                te.setText(s);
                break;

            case MotionEvent.ACTION_UP:
                s = "Up index = " + index + " x = " + event.getX() + " y = " + event.getY();
                te.setText(s);
                break;

            case MotionEvent.ACTION_POINTER_DOWN :
                s = "Pointer Down index = " + index + " x = " + event.getX() + " y = " + event.getY();
                te.setText(s);
                break;

            case MotionEvent.ACTION_POINTER_UP:
                s = "Pointer Up index = " + index + " x = " + event.getX() + " y = " + event.getY();
                te.setText(s);
                break;
        }

        if (event.getPointerCount() == 2){
            switch (action){
                case MotionEvent.ACTION_POINTER_DOWN:
                    d1 = getDistance(event);
                    s = "Pointer Down d1 = " + d1;
                    te.setText(s);
                    break;

                case MotionEvent.ACTION_MOVE:
                    d2 = getDistance(event);
                    m = new Matrix();
                    r = d2 / d1;
                    m.postScale(r, r);
                    iv.setImageMatrix(m);

                    s = "Move d1 = " + d1 + " d2 = " + d2;
                    te.setText(s);
                    break;

                case MotionEvent.ACTION_POINTER_UP:
                    d2 = getDistance(event);
                    m = new Matrix();
                    r = d2 / d1;
                    m.postScale(r, r);
                    iv.setImageMatrix(m);
                    s = "Pointer Up d1 = " + d1 + " d2 = " + d2;
                    te.setText(s);
                    break;
            }
        }

        return super.onTouchEvent(event);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        te = (TextView) findViewById(R.id.text);
        iv = (ImageView) findViewById(R.id.image);
    }
}