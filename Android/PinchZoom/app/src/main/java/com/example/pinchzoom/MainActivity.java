package com.example.pinchzoom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;

    String s;
    Matrix m;

    float d1, d2, r;

    float getDistance(MotionEvent ev){
        float dx = ev.getX(1) - ev.getX(0);
        float dy = ev.getY(1) - ev.getY(0);

        return (float)Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action;
        int index;

        action = event.getAction() & 0xff;
        index = (event.getAction() & 0xff00) >> 8;

        switch (action){
            case MotionEvent.ACTION_DOWN:
                s = "Down index = " + index + " x = " + event.getX() + " y = " + event.getY();
                textView.setText(s);
                break;

            case MotionEvent.ACTION_MOVE:
                s = "Move index = " + index + " x = " + event.getX() + " y = " + event.getY();
                textView.setText(s);
                break;

            case MotionEvent.ACTION_UP:
                s = "Up index = " + index + " x = " + event.getX() + " y = " + event.getY();
                textView.setText(s);
                break;

            case MotionEvent.ACTION_POINTER_DOWN :
                s = "Pointer Down index = " + index + " x = " + event.getX() + " y = " + event.getY();
                textView.setText(s);
                break;

            case MotionEvent.ACTION_POINTER_UP:
                s = "Pointer Up index = " + index + " x = " + event.getX() + " y = " + event.getY();
                textView.setText(s);
                break;
        }

        if (event.getPointerCount() == 2){
            switch(action){
                case MotionEvent.ACTION_POINTER_DOWN:
                    d1 = getDistance(event);
                    s = "Pointer Down d1 = " + d1;
                    textView.setText(s);
                    break;

                case MotionEvent.ACTION_MOVE:
                    d2 = getDistance(event);
                    m = new Matrix();
                    r = d2 / d1;
                    m.postScale(r, r);
                    imageView.setImageMatrix(m);

                    s = "Move d1 = " + d1 + " d2 = " + d2;
                    textView.setText(s);
                    break;

                case MotionEvent.ACTION_POINTER_UP:
                    d2 = getDistance(event);
                    m = new Matrix();
                    r = d2 / d1;
                    m.postScale(r, r);
                    imageView.setImageMatrix(m);
                    s = "Pointer Up d1 = " + d1 + " d2 = " + d2;
                    textView.setText(s);
                    break;
            }
        }

        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.text);

        imageView.setImageResource(R.drawable.picture1);

    }
}