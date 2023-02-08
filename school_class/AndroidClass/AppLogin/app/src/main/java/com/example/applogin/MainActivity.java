package com.example.applogin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int version = 1;
    EditText idInput,pwInput;
    Button login, joinMember;
    View.OnClickListener cl;
    Intent i;
    SQLiteDatabase sqlDB;
    memberDBHelper memberDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab = getSupportActionBar();   // Title 수정
        ab.setTitle("로그인");


        idInput = (EditText) findViewById(R.id.idinput);
        pwInput = (EditText) findViewById(R.id.pwinput);

        login = (Button) findViewById(R.id.loginbtn);
        joinMember = (Button) findViewById(R.id.joinbtn);

        memberDB = new memberDBHelper(MainActivity.this, memberDBHelper.tableName, null, version);
        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.loginbtn:
                        sqlDB = memberDB.getReadableDatabase();
                        Cursor cursor;
                        String idStr = idInput.getText().toString();
                        String pwStr = pwInput.getText().toString();

                        cursor = sqlDB.rawQuery("SELECT pw FROM memberTBL WHERE id = '"+ idStr + "';", null);
                        cursor.moveToFirst();
                        String res = cursor.getString(0);
                        if(cursor.getCount() != 1){
                            Toast.makeText(getApplicationContext(),"없는 ID 입니다.",0).show();
                        }
                        else if (res.equals( pwStr )){
                            Toast.makeText(getApplicationContext(), "로그인 성공", 0).show();

                        }
                        else if (!res.equals(pwStr)){
                            Toast.makeText(getApplicationContext(), "비밀번호가 다릅니다.", 0).show();
                        }

                        cursor.close();
                        sqlDB.close();
                        break;

                    case R.id.joinbtn:
                        i = new Intent(getApplicationContext(), JoinMember.class);
                        startActivity(i);
                        break;
                }
            }
        };

        login.setOnClickListener(cl);
        joinMember.setOnClickListener(cl);




    }


}