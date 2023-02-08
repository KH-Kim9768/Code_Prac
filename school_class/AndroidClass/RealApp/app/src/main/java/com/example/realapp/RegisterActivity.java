package com.example.realapp;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e2, e3, e4;
    Button b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.join );

        db = new DatabaseHelper(this);
        e2 = (EditText) findViewById(R.id.join_id);
        e3 = (EditText) findViewById(R.id.join_password);
        e4 = (EditText) findViewById(R.id.join_pwck);
        b1 = (Button) findViewById(R.id.join_button);
        b2 = (Button) findViewById(R.id.delete);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                if (s2.equals("") || s3.equals("") || s4.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "아이디/비밀번호/비밀번호 확인을 작성하지 않았습니다.",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    if (s3.equals(s4)) {
                        Boolean chkid = db.chkid(s2);
                        if (chkid == true) {
                            Boolean insert = db.insert(s2, s3);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "회원가입 완료",
                                        Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "아이디가 존재합니다.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
