package com.example.dialogbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button basic, basic2, sexdbox, soccerbox, tel, ani, mul;
    View.OnClickListener cl;
    AlertDialog.Builder dlg;
    DialogInterface.OnClickListener yes, no, yes1, no1, yes2, no2, yes3, tcom, anim;
    DialogInterface.OnMultiChoiceClickListener mcl;
    String[] tele;
    String[] animal;
    int choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tele = new String[4];
        tele[0] = "KT";
        tele[1] = "LG";
        tele[2] = "SK";
        tele[3] = "기타";

        animal = new String[5];
        animal[0] = "강아지";
        animal[1] = "고양이";
        animal[2] = "호랑이";
        animal[3] = "닭";
        animal[4] = "앵무새";
        
        basic = (Button) findViewById(R.id.basicbox);
        basic2 = (Button) findViewById(R.id.basicbox2);
        sexdbox = (Button) findViewById(R.id.sexdbox);
        soccerbox = (Button) findViewById(R.id.soccerbox);
        tel = (Button) findViewById(R.id.telecom);
        ani = (Button) findViewById(R.id.animal);
        mul = (Button) findViewById(R.id.multiple);

        yes = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "당신은 남성이군요!", Toast.LENGTH_LONG).show();
            }
        };

        no = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "당신은 여성이군요!", Toast.LENGTH_LONG).show();
            }
        };

        yes1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "당신은 축구를 좋아하시네요", Toast.LENGTH_LONG).show();
            }
        };

        no1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "당신은 축구를 안 좋아하시네요", Toast.LENGTH_LONG).show();
            }
        };

        yes2 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "당신의 최종 선택은 " + animal[choice], Toast.LENGTH_LONG).show();
            }
        };

        no2 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "선택을 취소합니다", Toast.LENGTH_LONG).show();
            }
        };

        tcom = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "당신의 통신사는 " + tele[which], Toast.LENGTH_LONG).show();
            }
        };

        anim = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = which;
                Toast.makeText(getApplicationContext(), "제일 좋아하는 동물은 " + animal[which], Toast.LENGTH_LONG).show();
            }
        };

        mcl = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getApplicationContext(), "당신이 좋아하는 동물은 " + animal[which], Toast.LENGTH_LONG).show();
            }
        };



        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.basicbox:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("공지합니다");
                        dlg.setMessage("이번 주 중간고사는 연기되었습니다.");
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.show();
                        break;

                    case R.id.basicbox2:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("나의 취미");
                        dlg.setMessage("나의 취미는 영화 감상입니다.");
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.show();
                        break;

                    case R.id.sexdbox:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("성별 판별");
                        dlg.setMessage("당신은 남성입니까?");
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.setPositiveButton("예", yes);
                        dlg.setNegativeButton("아니오", no);
                        dlg.show();
                        break;

                    case R.id.soccerbox:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("축구 선호 조사");
                        dlg.setMessage("당신은 축구를 좋아합니까?");
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.setPositiveButton("예", yes1);
                        dlg.setNegativeButton("아니오", no1);
                        dlg.show();
                        break;

                    case R.id.telecom:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("통신사는?");
                        dlg.setItems(tele, tcom);
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.show();
                        break;

                    case R.id.animal:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("제일 좋아하는 동물은?");
                        dlg.setSingleChoiceItems(animal, 0, anim);
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.setPositiveButton("선택 완료", yes2);
                        dlg.setNegativeButton("취소", no2);
                        dlg.show();
                        break;

                    case R.id.multiple:
                        boolean[] init = new boolean[5];
                        init[0] = true;
                        init[1] = true;
                        init[2] = false;
                        init[3] = false;
                        init[4] = true;

                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("당신이 좋아하는 동물은?");
                        dlg.setMultiChoiceItems(animal, init, mcl);
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.setPositiveButton("선택 완료", yes2);
                        dlg.setNegativeButton("취소", no2);
                        dlg.show();
                        break;
                }
            }
        };

        basic.setOnClickListener(cl);
        basic2.setOnClickListener(cl);
        sexdbox.setOnClickListener(cl);
        soccerbox.setOnClickListener(cl);
        tel.setOnClickListener(cl);
        ani.setOnClickListener(cl);
        mul.setOnClickListener(cl);
    }
}