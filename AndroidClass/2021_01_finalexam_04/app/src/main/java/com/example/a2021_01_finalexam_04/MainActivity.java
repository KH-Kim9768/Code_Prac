package com.example.a2021_01_finalexam_04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView sum;
    Button call;
    View.OnClickListener vcl;
    View dview;
    DialogInterface.OnClickListener dcl;
    AlertDialog.Builder adialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sum = (TextView) findViewById(R.id.sum);
        call = (Button) findViewById(R.id.call);

        dcl = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText n1, n2;

            }
        };

        vcl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dview = View.inflate(MainActivity.this, R.layout.myinput, null);
                
            }
        };

        call.setOnClickListener(vcl);



    }
}