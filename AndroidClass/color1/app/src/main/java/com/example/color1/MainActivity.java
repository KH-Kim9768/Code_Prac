package com.example.color1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nam, red, gre, blu;
    Button pin, yel, cya, sho;
    View.OnClickListener cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nam = (EditText) findViewById(R.id.name);
        pin = (Button) findViewById(R.id.pink);
        yel = (Button) findViewById(R.id.yellow);
        cya = (Button) findViewById(R.id.cyan);
        sho = (Button) findViewById(R.id.show);
        red = (EditText) findViewById(R.id.rr);
        gre = (EditText) findViewById(R.id.gg);
        blu = (EditText) findViewById(R.id.bb);

        cl = new View.OnClickListener(){

            public void onClick(View v){
                switch (v.getId()){
                    case R.id.pink:
                        nam.setBackgroundColor(Color.MAGENTA);
                        nam.setText("홍길동님 반가워요");
                        break;
                    case R.id.yellow:
                        nam.setBackgroundColor(Color.YELLOW);
                        break;
                    case R.id.cyan:
                        nam.setBackgroundColor(Color.CYAN);
                        break;
                    case R.id.show:
                        int r, g, b;
                        r = Integer.parseInt(red.getText().toString());
                        g = Integer.parseInt(gre.getText().toString());
                        b = Integer.parseInt(blu.getText().toString());
                        nam.setBackgroundColor(Color.rgb(r,g,b));
                        break;
                }
            }
        };

        pin.setOnClickListener(cl);
        yel.setOnClickListener(cl);
        cya.setOnClickListener(cl);
        sho.setOnClickListener(cl);

    }
}