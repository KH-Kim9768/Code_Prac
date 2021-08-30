package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public class myDBHelper extends SQLiteOpenHelper{
        public myDBHelper(Context context){
            super(context, "memberDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL("CREATE TABLE memberTBL ( ID CHAR(10) PRIMARY KEY, PW CHAR(20));");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS memberTBL");
            onCreate(db);
        }
    }

    myDBHelper myHelper;
    EditText edtId, edtPw, edtIdResult, edtPwResult;
    Button btnInit, btnInsert, btnSelect;
    SQLiteDatabase sqldb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("회원가입 테스트");

        edtId = (EditText) findViewById(R.id.edtId);
        edtPw = (EditText) findViewById(R.id.edtPassword);
        edtIdResult = (EditText) findViewById(R.id.edtIdResult);
        edtPwResult = (EditText) findViewById(R.id.edtPwResult);

        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);



        myHelper = new myDBHelper(this);


        btnInit.setOnClickListener(new View.OnClickListener(){  // 초기화 눌렀을 시
            public void onClick(View v){
                sqldb = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqldb, 1, 2);
                sqldb.close();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener(){    // 입력 눌렀을 시
            public void onClick(View v){
                sqldb = myHelper.getWritableDatabase();
                sqldb.execSQL("INSERT INTO memberTBL VALUES ( '"
                 + edtId.getText().toString() + "', '"+ edtPw.getText().toString() +"');");
                sqldb.close();
                Toast.makeText(getApplicationContext(), "입력완료", 0).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sqldb = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqldb.rawQuery("SELECT * FROM memberTBL;", null);

                String strIDs = " ID " + "\n" + "--------" + "\n";
                String strPWs = " PW " + "\n" + "--------" + "\n";

                while (cursor.moveToNext()){
                    strIDs += cursor.getString(0) + "\r\n";
                    strPWs += cursor.getString(1) + "\r\n";

                }

                edtIdResult.setText(strIDs);
                edtPwResult.setText(strPWs);

                cursor.close();
                sqldb.close();

            }
        });


    }
}