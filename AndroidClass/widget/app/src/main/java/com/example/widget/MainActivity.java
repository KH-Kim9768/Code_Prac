package com.example.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText te1;
    Button red;
    CheckBox ban, app, ora, kiw;
    RadioButton gr1, gr2, gr3, mal, fem;
    ImageButton img;
    ImageView iv;
    ProgressBar pb1, pb2;
    SeekBar se1, se2;
    RatingBar rb;
    ToggleButton tog;
    Switch sw;


    SeekBar.OnSeekBarChangeListener scl;
    CompoundButton.OnCheckedChangeListener cb;
    View.OnClickListener cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        te1 = (EditText) findViewById(R.id.text1);
        red = (Button) findViewById(R.id.red);
        ban = (CheckBox) findViewById(R.id.banana);
        app = (CheckBox) findViewById(R.id.apple);
        ora = (CheckBox) findViewById(R.id.orange);
        kiw = (CheckBox) findViewById(R.id.kiwi);
        gr1 = (RadioButton) findViewById(R.id.grade1);
        gr2 = (RadioButton) findViewById(R.id.grade2);
        gr3 = (RadioButton) findViewById(R.id.grade3);
        mal = (RadioButton) findViewById(R.id.male);
        fem = (RadioButton) findViewById(R.id.female);
        img = (ImageButton) findViewById(R.id.image);
        iv = (ImageView) findViewById(R.id.imgview);
        pb1 = (ProgressBar) findViewById(R.id.prog1);
        pb2 = (ProgressBar) findViewById(R.id.prog2);
        se1 = (SeekBar) findViewById(R.id.seek1);
        se2 = (SeekBar) findViewById(R.id.seek2);
        rb = (RatingBar) findViewById(R.id.ratingBar);
        tog = (ToggleButton) findViewById(R.id.toggle);
        sw = (Switch) findViewById(R.id.television) ;

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.red:
                        te1.setBackgroundColor(Color.RED);
                        iv.setImageResource(R.drawable.arrow);
                        pb2.setProgress(pb2.getProgress()+5);
                        pb2.setSecondaryProgress(pb2.getSecondaryProgress() +7);
                        se1.setProgress(se1.getProgress() + 5);
                        se2.setProgress(se2.getProgress() + 1);
                        break;

                    case R.id.image:
                        te1.setText("이미지 버튼 눌렀어요");
                        img.setImageResource(R.drawable.star);
                        pb1.setVisibility(View.INVISIBLE);
                        rb.setRating(rb.getRating() + 1);
                        break;
                }
            }
        };

        cb = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                switch (compoundButton.getId()){
                    case R.id.banana:
                        if (b == true)
                            te1.setText("당신은 바나나를 좋아하네요");
                        else
                            te1.setText("당신은 바나나를 싫어하네요");
                        break;

                    case R.id.apple:
                        if (b == true)
                            te1.setText("당신은 사과를 좋아하네요");
                        else
                            te1.setText("당신은 사과를 싫어하네요");
                        break;

                    case R.id.orange:
                        if(b == true)
                            te1.setText("당신은 오렌지를 좋아하네요");
                        else
                            te1.setText("당신은 오렌지를 싫어하네요");
                        break;

                    case R.id.kiwi:
                        if(b)
                            te1.setText("당신은 키위를 좋아하네요");
                        else
                            te1.setText("당신은 키위를 싫어하네요");
                        break;

                    case R.id.grade1:
                        if(b)
                            te1.setText("당신은 1학년입니다.");
                        else
                            red.setText("당신은 1학년이 아닙니다");
                        break;

                    case R.id.grade2:
                        if(b)
                            te1.setText("당신은 2학년입니다.");
                        else
                            red.setText("당신은 2학년이 아닙니다");
                        break;

                    case R.id.grade3:
                        if(b)
                            te1.setText("당신은 3학년입니다.");
                        else
                            red.setText("당신은 3학년이 아닙니다");
                        break;

                    case R.id.male:
                        if(b)
                            te1.setText("당신은 남성이군요");
                        else
                            red.setText("당신은 남성이 아니군요");
                        break;

                    case R.id.female:
                        if(b)
                            te1.setText("당신은 여성이군요");
                        else
                            red.setText("당신은 여성이 아니군요");
                        break;

                    case R.id.toggle:
                        if(b)
                            te1.setText("토글 is On");
                        else
                            te1.setText("토글 is Off");
                        break;

                    case R.id.television:
                        if(b)
                            te1.setText("TV is On");
                        else
                            te1.setText("TV is Off");
                        break;
                }
            }
        };

        scl = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch(seekBar.getId()){
                    case R.id.seek1:
                        te1.setText("연속 시크바 = " + i);
                        break;

                    case R.id.seek2:
                        te1.setText("이산 시크바 = " + i);
                        break;
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        red.setOnClickListener(cl);
        img.setOnClickListener(cl);
        ban.setOnCheckedChangeListener(cb);
        app.setOnCheckedChangeListener(cb);
        ora.setOnCheckedChangeListener(cb);
        kiw.setOnCheckedChangeListener(cb);
        gr1.setOnCheckedChangeListener(cb);
        gr2.setOnCheckedChangeListener(cb);
        gr3.setOnCheckedChangeListener(cb);
        mal.setOnCheckedChangeListener(cb);
        fem.setOnCheckedChangeListener(cb);
        tog.setOnCheckedChangeListener(cb);
        sw.setOnCheckedChangeListener(cb);
        se1.setOnSeekBarChangeListener(scl);
        se2.setOnSeekBarChangeListener(scl);
    }
}