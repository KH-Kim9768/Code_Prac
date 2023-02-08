package com.example.change;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText inp;
    Button blu, red, gre, yel, cya, mag;
    View.OnClickListener cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inp = (EditText) findViewById(R.id.input);
        blu = (Button) findViewById(R.id.blue);
        red = (Button) findViewById(R.id.red);
        gre = (Button) findViewById(R.id.green);
        yel = (Button) findViewById(R.id.yellow);
        cya = (Button) findViewById(R.id.cyan);
        mag = (Button) findViewById(R.id.magenta);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.blue:
//                        inp.setBackgroundColor(Color.BLUE);
                        inp.setTextColor(Color.BLUE);
                        break;

                    case R.id.red:
//                        inp.setBackgroundColor(Color.RED);
                        inp.setTextColor(Color.RED);
                        break;

                    case R.id.green:
//                        inp.setBackgroundColor(Color.GREEN);
                        inp.setTextColor(Color.GREEN);
                        break;

                    case R.id.yellow:
                        inp.setTextColor(Color.YELLOW);
                        break;

                    case R.id.cyan:
                        inp.setTextColor(Color.CYAN);
                        break;

                    case R.id.magenta:
                        inp.setTextColor(Color.MAGENTA);
                        break;
                }
            }
        };

        blu.setOnClickListener(cl);
        red.setOnClickListener(cl);
        gre.setOnClickListener(cl);
        yel.setOnClickListener(cl);
        cya.setOnClickListener(cl);
        mag.setOnClickListener(cl);

    }
}