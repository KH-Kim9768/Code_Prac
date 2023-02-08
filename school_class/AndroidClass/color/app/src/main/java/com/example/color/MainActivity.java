package com.example.color;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    EditText na;
    Button re, bl, gr, sh;
    View.OnClickListener cl;
    LinearLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        na = (EditText) findViewById(R.id.name); // R 은 Resource
        re = (Button) findViewById(R.id.red);
        bl = (Button) findViewById(R.id.blue);
        gr = (Button) findViewById(R.id.green);
        sh = (Button) findViewById(R.id.show);
        bg = (LinearLayout) findViewById(R.id.back);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.red:
                        na.setBackgroundColor(Color.RED);
                        bg.setBackgroundColor(Color.RED);
                        na.setText("RED");
                        break;

                    case R.id.blue:
                        na.setBackgroundColor(Color.BLUE);
                        bg.setBackgroundColor(Color.BLUE);
                        na.setText("BLUE");
                        break;

                    case R.id.green:
                        na.setBackgroundColor(Color.GREEN);
                        bg.setBackgroundColor(Color.GREEN);
                        na.setText("GREEN");
                        break;

                    case R.id.show:
                        sh.setText(na.getText().toString()); //na에 있는 Text를 문자열로 가져온다.
                }
            }
        };
        re.setOnClickListener(cl);
        bl.setOnClickListener(cl);
        gr.setOnClickListener(cl);
        sh.setOnClickListener(cl);
    }
}