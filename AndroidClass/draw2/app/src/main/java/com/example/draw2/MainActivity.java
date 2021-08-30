package com.example.draw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    EditText nam, textwid;
    Button red, blu, lin, rec, cir, tri, tri2, str, fil, wid1, wid2, wid3, wid4, wid5, acc;
    View.OnClickListener cl;
    LinearLayout are;
    int color = Color.GREEN;
    int type = 1; // 1:line 2:rectangle 3:circle 4:triangle 5:
    int style = 1; // 1:Stroke 2:Fill
    int width = 1;

    class yourView extends View{

        Paint pp;
        float x1, y1, x2, y2;


        yourView(Context con){
            super(con);
            pp = new Paint();
        }

        @Override
        protected void onDraw(Canvas can) {
            super.onDraw(can);

            pp.setColor(color);

            pp.setStrokeWidth(width);

            if ( style == 1 ) {
                pp.setStyle(Paint.Style.STROKE);
            } else if ( style == 2 ) {
                pp.setStyle(Paint.Style.FILL);
            }

            if (type == 1) {
                can.drawLine(x1, y1, x2, y2, pp);
            } else if( type == 2) {
                can.drawRect(x1, y1, x2, y2, pp);
            } else if (type == 3) {
                float r;
                r = (float) Math.sqrt( (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) );
                can.drawCircle(x1, y1, r, pp);
            } else if (type == 4) {
                can.drawLine((x1+x2)/2, y1, x1, y2, pp);
                can.drawLine(x1, y2, x2, y2, pp);
                can.drawLine((x2+x1)/2, y1, x2, y2, pp);
            } else if (type == 5) {
                can.drawLine(x1, y1, (x1+x2)/2, y2, pp);
                can.drawLine(x1, y1, x2, y1, pp);
                can.drawLine(x2, y1, (x1+x2)/2, y2, pp);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            if ( ev.getAction() == MotionEvent.ACTION_DOWN ){
                x1 = ev.getX();
                y1 = ev.getY();
            }

            else if ( ev.getAction() == MotionEvent.ACTION_UP ) {
                x2 = ev.getX();
                y2 = ev.getY();
                invalidate();
            }

            else if ( ev.getAction() == MotionEvent.ACTION_MOVE ) {
                x2 = ev.getX();
                y2 = ev.getY();
                invalidate();
            }
            return true;//super.onTouchEvent(event);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        yourView bb;
        bb = new yourView(this);
        setContentView(R.layout.activity_main);


        nam = (EditText) findViewById(R.id.name);
        textwid = (EditText) findViewById(R.id.textWidth);
        red = (Button) findViewById(R.id.red);
        blu = (Button) findViewById(R.id.blue);
        lin = (Button) findViewById(R.id.line);
        rec = (Button) findViewById(R.id.rect);
        cir = (Button) findViewById(R.id.circle);
        tri = (Button) findViewById(R.id.triangle);
        tri2 = (Button) findViewById(R.id.triangle2);
        str = (Button) findViewById(R.id.stroke);
        fil = (Button) findViewById(R.id.fill);
        wid1 = (Button) findViewById(R.id.width1);
        wid2 = (Button) findViewById(R.id.width2);
        wid3 = (Button) findViewById(R.id.width3);
        wid4 = (Button) findViewById(R.id.width4);
        wid5 = (Button) findViewById(R.id.width5);
        acc = (Button) findViewById(R.id.accept);
        are = (LinearLayout) findViewById(R.id.area);

        are.addView(bb);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.red:
                        nam.setBackgroundColor(Color.RED);
                        color = Color.RED;
                        break;

                    case R.id.blue:
                        nam.setBackgroundColor(Color.BLUE);
                        color = Color.BLUE;
                        break;

                    case R.id.line:
                        type = 1;
                        break;

                    case R.id.rect:
                        type = 2;
                        break;

                    case R.id.circle:
                        type = 3;
                        break;

                    case R.id.triangle:
                        type = 4;
                        break;

                    case R.id.triangle2:
                        type = 5;
                        break;

                    case R.id.stroke:
                        style = 1;
                        break;

                    case R.id.fill:
                        style = 2;
                        break;

                    case R.id.width1:
                        width = 1;
                        break;

                    case R.id.width2:
                        width = 3;
                        break;

                    case R.id.width3:
                        width = 6;
                        break;

                    case R.id.width4:
                        width = 9;
                        break;

                    case R.id.width5:
                        width = 12;
                        break;

                    case R.id.accept:
                        width = Integer.parseInt(textwid.getText().toString());
                        break;
                }
            }
        };



        red.setOnClickListener(cl);
        blu.setOnClickListener(cl);
        lin.setOnClickListener(cl);
        rec.setOnClickListener(cl);
        cir.setOnClickListener(cl);
        tri.setOnClickListener(cl);
        tri2.setOnClickListener(cl);
        str.setOnClickListener(cl);
        fil.setOnClickListener(cl);
        wid1.setOnClickListener(cl);
        wid2.setOnClickListener(cl);
        wid3.setOnClickListener(cl);
        wid4.setOnClickListener(cl);
        wid5.setOnClickListener(cl);
        acc.setOnClickListener(cl);


    }
}