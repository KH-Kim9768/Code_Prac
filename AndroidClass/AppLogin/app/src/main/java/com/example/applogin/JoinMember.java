package com.example.applogin;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JoinMember extends AppCompatActivity {
    int version = 1;
    EditText insertId, insertPw, insertPwChk, insertName, insertNickname;
    Button joinBtn;
    View.OnClickListener cl;
    memberDBHelper helper;
    SQLiteDatabase sqlDB;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_member);

        insertId = (EditText) findViewById(R.id.insertid);
        insertPw = (EditText) findViewById(R.id.insertpw);
        insertPwChk = (EditText) findViewById(R.id.insertpwchk);
        insertName = (EditText) findViewById(R.id.insertname);
        insertNickname = (EditText) findViewById(R.id.insertnickname);
        joinBtn = (Button) findViewById(R.id.join);

        helper = new memberDBHelper(JoinMember.this, memberDBHelper.tableName, null, version);


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.join:
                        String id = insertId.getText().toString();
                        String pw = insertPw.getText().toString();
                        String pwchk = insertPwChk.getText().toString();
                        String name = insertName.getText().toString();
                        String nickname = insertNickname.getText().toString();

                        if (id == null && pw == null && pwchk == null && name == null && nickname ==null){
                            Toast.makeText(getApplicationContext(), "모든 항목을 입력해 주세요.", 0).show();

                        } else if ( pw.equals(pwchk) == false ){
                            Toast.makeText(getApplicationContext(), "비밀번호 확인이 일치하지 않습니다.", 0).show();

                        }
                        else {
                            sqlDB = helper.getWritableDatabase();
                            helper.insertMember(sqlDB, id, pw, name, nickname);
                            Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", 0).show();
                            finish();

                        }

                        break;

                }
            }
        };

        joinBtn.setOnClickListener(cl);

    }
}
