package com.example.mydraw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyView mv;
    int color = Color.BLACK;
    int type = 1;


    class MyView extends View{
        Paint p;

        MyView(Context c){
            super(c);
            p = new Paint();

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super .onDraw(canvas);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(5);
            p.setColor(color);

            switch(type){
                case 1:
                    canvas.drawLine(20, 40, 300, 370, p);
                    break;

                case 2:
                    canvas.drawRect(20, 40, 300, 370, p);
                    break;

                case 3:
                    canvas.drawCircle(200, 400, 100, p);
                    break;

                case 4:
                    canvas.drawOval(20,40,300,370, p);
                    break;

            }
//            canvas.drawRect(20, 40, 300,370, p);
/*
            canvas.drawOval(50, 60, 400, 500, p);

            p.setStyle(Paint.Style.FILL);
            canvas.drawArc(60, 60, 390, 340, 180, 180, true, p);

            canvas.drawCircle(130, 285, 20, p);
            canvas.drawCircle(320, 285, 20, p);

            p.setColor(Color.RED);
            canvas.drawOval(180, 410, 270, 430, p);

            p.setStyle(Paint.Style.STROKE);

            p.setColor(Color.BLACK);
            p.setStrokeWidth(15);
            canvas.drawLine(80, 250, 180, 250, p);
            canvas.drawLine(270, 250, 370, 250, p);

            p.setStrokeWidth(5);
            canvas.drawLine(225, 300, 250, 360, p);
            canvas.drawLine(225, 360, 250, 360, p);
*/

//            p.setColor(Color.RED);
//            canvas.drawLine(20, 40, 320, 370, p);
//
//            p.setColor(Color.BLUE);
//            canvas.drawRect(150, 390, 470, 700, p);
//
//            p.setColor(Color.GREEN);
//            canvas.drawCircle(300, 150, 50, p);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mv = new MyView(this);
        setContentView(mv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 101, 0, "빨간색");
        menu.add(0, 102, 0, "파란색");
        menu.add(0, 103, 0, "초록색");

        SubMenu sm;
        sm = menu.addSubMenu("기타");
        sm.add(0, 201, 0, "노란색");
        sm.add(0, 202, 0, "하늘색");
        sm.add(0, 203, 0, "분홍색");

        sm = menu.addSubMenu("내가 좋아하는 색");
        sm.add(0, 301, 0, "회색");
        sm.add(0, 302, 0, "연한 노랑색");
        sm.add(0, 303, 0, "짙은 초록색");

        sm = menu.addSubMenu("도형 선택");
        sm.add(0, 401, 0, "직선");
        sm.add(0, 402, 0, "사각형");
        sm.add(0, 403, 0, "원");
        sm.add(0, 404, 0, "타원");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 101:
                color = Color.RED;
                mv.invalidate();
                break;

            case 102:
                color = Color.BLUE;
                mv.invalidate();
                break;

            case 103:
                color = Color.GREEN;
                mv.invalidate();
            break;

            case 201:
                color = Color.YELLOW;
                mv.invalidate();
                break;

            case 202:
                color = Color.CYAN;
                mv.invalidate();
                break;

            case 203:
                color = Color.MAGENTA;
                mv.invalidate();
                break;

            case 301:
                color = Color.GRAY;
                mv.invalidate();
                break;

            case 302:
                color = Color.rgb(255, 255, 128);
                mv.invalidate();
                break;

            case 303:
                color = Color.rgb(129, 205, 70);
                mv.invalidate();
                break;

            case 401:
                type = 1;
                mv.invalidate();
                break;

            case 402:
                type = 2;
                mv.invalidate();
                break;

            case 403:
                type = 3;
                mv.invalidate();
                break;

            case 404:
                type = 4;
                mv.invalidate();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}