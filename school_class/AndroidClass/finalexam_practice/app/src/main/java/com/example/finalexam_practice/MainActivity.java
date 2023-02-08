package com.example.finalexam_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    float x1= 0, y1 = 0, x2 = 0, y2 = 0;
    int color = Color.RED;
    int type = 1;
    Paint p;

    class MyView extends View {
        MyView(Context c){
            super(c);
            p = new Paint();
        }

        protected  void onDraw(Canvas canvas){
            super.onDraw(canvas);
            p.setColor(color);
            p.setStyle(Paint.Style.FILL);

            if (type == 1 ){
                canvas.drawLine(x1, y1, x2, y2, p);
            } else if (type == 2) {
                canvas.drawRect(x1, y1, x2, y2, p);
            }


        }

        public boolean onTouchEvent(MotionEvent event) {
            switch ( event.getAction() ) {
                case MotionEvent.ACTION_DOWN :
                    x1 = event.getX() ;
                    y1 = event.getY() ;
                    break ;
                case MotionEvent.ACTION_MOVE :
                    x2 = event.getX() ;
                    y2 = event.getY() ;
                    invalidate();
                    break ;
                case MotionEvent.ACTION_UP :
                    x2 = event.getX() ;
                    y2 = event.getY() ;
                    invalidate();
                    break ;
            }
            return true ;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView mv = new MyView(this) ;
        setContentView(mv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu color, type;

        color = menu.addSubMenu("색깔 변경");
        color.add(0, 101, 0, "빨강");
        color.add(0, 102, 0, "녹색");
        color.add(0, 103, 0, "파랑");

        type = menu.addSubMenu("모양 변경");
        type.add(0, 201, 0,  "직선");
        type.add(0, 202, 0, "사각형");
       return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 101:
                color = Color.RED;
                break;

            case 102:
                color = Color.GREEN;
                break;

            case 103:
                color = Color.BLUE;
                break;

            case 201:
                type = 1;
                break;

            case 202:
                type = 2;
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}