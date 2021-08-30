package com.example.pw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    Button tele, idpw, nameage, setrb;
    EditText te, id, pw, name, age;
    View.OnClickListener cl;
    RadioGroup rg;
    RadioButton male, female;
    RatingBar rb;
    ProgressBar pb;


    String[] comm;
    String sex;
    AlertDialog.Builder dlg;
    DialogInterface.OnClickListener yes, no, tel_choice, yes1, no1, yes2, no2;
    View myview, myview2;


    int choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tele = (Button) findViewById(R.id.telecom);
        idpw = (Button) findViewById(R.id.idpw);
        nameage = (Button) findViewById(R.id.nameagesex);
        te = (EditText) findViewById(R.id.text);
        rb = (RatingBar) findViewById(R.id.rate);
        setrb = (Button) findViewById(R.id.setstar);
        pb = (ProgressBar) findViewById(R.id.progress);

        comm = new String[3];
        comm[0] = "SK";
        comm[1] = "KT";
        comm[2] = "LG";

        tel_choice = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = which;
            }
        };

        yes = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                te.setText("번호 = " + choice + " 통신사 = " + comm[choice]);
            }
        };

        no = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                te.setText("선택 취소");
            }
        };

        yes1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                id = (EditText) myview.findViewById(R.id.myid);
                pw = (EditText) myview.findViewById(R.id.mypw);
                te.setText("ID = " + id.getText().toString() + " PASSWORD = " + pw.getText().toString());
            }
        };

        no1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                te.setText("ID, PW 입력 취소");
            }
        };

        yes2 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                name = (EditText) myview2.findViewById(R.id.name);
                age = (EditText) myview2.findViewById(R.id.age);
                rg = (RadioGroup) myview2.findViewById(R.id.rg_gender);
                male = (RadioButton) myview2.findViewById(R.id.rb_male);
                female = (RadioButton) myview2.findViewById(R.id.rb_female);

                if (male.isChecked()){
                    sex = "남성";
                } else if(female.isChecked()){
                    sex = "여성";
                } else {
                    sex = "알 수 없음";
                }


                te.setText("이름 = " + name.getText().toString() + " 나이 = " + age.getText().toString() + " 성별 = " + sex);


            }
        };

        no2 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                te.setText("이름, 나이, 성별 입력 취소");
            }
        };

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.telecom:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.setTitle("통신사를 선택해 주세요");
                        dlg.setSingleChoiceItems(comm, 0, tel_choice);
                        dlg.setPositiveButton("선택완료", yes);
                        dlg.setNegativeButton("취소", no);
                        dlg.show();
                        break;

                    case R.id.idpw:
                        myview = (View) View.inflate(MainActivity.this, R.layout.myidpw, null);
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.setTitle("ID, Passwd 입력");
                        dlg.setView(myview);
                        dlg.setPositiveButton("입력완료", yes1);
                        dlg.setNegativeButton("입력취소", no1);
                        dlg.show();
                        break;

                    case R.id.nameagesex:
                        myview2 = (View) View.inflate(MainActivity.this, R.layout.myname, null);
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.setTitle("이름/나이/성별 입력");
                        dlg.setView(myview2);
                        dlg.setPositiveButton("입력완료", yes2);
                        dlg.setNegativeButton("입력취소", no2);
                        dlg.show();
                        break;

                    case R.id.setstar:
                        float getrate = Float.parseFloat(te.getText().toString());
                        float f, f1;
                        int i;
//                        rb.setRating(getrate);
//                        f = rb.getRating();
                        i = Integer.parseInt(te.getText().toString());
                        pb.setProgress(i);
                        break;

                }

            }
        };

        tele.setOnClickListener(cl);
        idpw.setOnClickListener(cl);
        nameage.setOnClickListener(cl);
        setrb.setOnClickListener(cl);
    }
}