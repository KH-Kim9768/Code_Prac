package com.example.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText cnt1, cnt2, cnt3;
    Button add, add1, add2, stop1, stop2, stop3;
    View.OnClickListener cl;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;


    boolean b1, b2, b3 = true;
    MyHandler mh;

    class MyHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                cnt1.setText("counter1 = " + i1);
            }
            else if (msg.what == 2){
                cnt2.setText("counter2 = " + i2);
            }
            else if (msg.what == 3){
                cnt3.setText("counter3 = " + i3);
            }


        }
    }

    class MyThread1 extends Thread{

        @Override
        public void run() {
            super.run();

            while(b1){
                mh.sendEmptyMessage(1);
                SystemClock.sleep(500);
                i1++;
            }
        }
    }

    class MyThread2 extends Thread{

        @Override
        public void run() {
            super.run();
            while(b2){
                mh.sendEmptyMessage(2);
                SystemClock.sleep(500);
                i2++;
            }
        }
    }

    class MyThread3 extends Thread{

        @Override
        public void run() {
            super.run();
            while(b3){
                mh.sendEmptyMessage(3);
                SystemClock.sleep(500);
                i3++;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cnt1 = (EditText) findViewById(R.id.counter1);
        cnt2 = (EditText) findViewById(R.id.counter2);
        cnt3 = (EditText) findViewById(R.id.counter3);

        add = (Button) findViewById(R.id.add);
        add1 = (Button) findViewById(R.id.add1);
        add2 = (Button) findViewById(R.id.add2);

        stop1 = (Button) findViewById(R.id.stop1);
        stop2 = (Button) findViewById(R.id.stop2);
        stop3 = (Button) findViewById(R.id.stop3);

        mh = new MyHandler();

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.add:
                        b1 = true;
                        MyThread1 myThread1 = new MyThread1();
                        myThread1.start();
                        break;

                    case R.id.add1:
                        b2 = true;
                        MyThread2 myThread2 = new MyThread2();
                        myThread2.start();
                        break;

                    case R.id.add2:
                        b3 = true;
                        MyThread3 myThread3 = new MyThread3();
                        myThread3.start();
                        break;

                    case R.id.stop1:
                        b1 = false;
                        break;

                    case R.id.stop2:
                        b2 = false;
                        break;

                    case R.id.stop3:

                        b3 = false;
                        break;
                }
            }
        };

        add.setOnClickListener(cl);
        add1.setOnClickListener(cl);
        add2.setOnClickListener(cl);
        stop1.setOnClickListener(cl);
        stop2.setOnClickListener(cl);
        stop3.setOnClickListener(cl);
    }
}