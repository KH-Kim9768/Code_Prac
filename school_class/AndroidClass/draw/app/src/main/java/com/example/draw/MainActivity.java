package com.example.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    class myView extends View {
        Paint p;
        String str = "EVENT";
        float x1, y1, x2, y2;

        myView(Context c){
            super(c);
            p = new Paint();

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            p.setColor(Color.BLUE);
            p.setStyle(Paint.Style.STROKE); // 외곽선
            p.setStrokeWidth(1); // 외곽선 두께
            canvas.drawText(str, 30, 30, p);
            canvas.drawRect(x1, y1, x2, y2, p);
            p.setColor(Color.GREEN);
            canvas.drawLine( x1, y1, x2, y2, p);
            canvas.drawLine( x2, y1, x1, y2, p);

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch(event.getAction() ){
                case MotionEvent.ACTION_DOWN:
                    str = String.format("DOWN_EVENT X = %f Y = %f", event.getX(), event.getY());
                    x1 = event.getX();
                    y1 = event.getY();
                    invalidate();
                    break;

                case MotionEvent.ACTION_MOVE:
                    str = String.format("MOVE_EVENT X = %f Y = %f", event.getX(), event.getY());
                    invalidate();
                    x2 = event.getX();
                    y2 = event.getY();
                    break;

                case MotionEvent.ACTION_UP:
                    str = String.format("UP_EVENT X = %f Y = %f", event.getX(), event.getY());
                    x2 = event.getX();
                    y2 = event.getY();
                    invalidate();
                    break;
            }

            return true;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView aa;
        aa= new myView(this);
        setContentView(aa);
    }
}