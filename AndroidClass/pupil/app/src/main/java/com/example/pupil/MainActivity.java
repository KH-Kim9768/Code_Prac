package com.example.pupil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText snum, kor, eng, mat, input, snum1, name, age, tel, sex;
    TextView te;
    Button in, se, up, de, sh, in1, se1, de1, up1;
    View.OnClickListener cl;
    myHelper mh;
    SQLiteDatabase dbase;
    Cursor cursor;
    String sql;

    class myHelper extends SQLiteOpenHelper{
        myHelper(Context c){
            super(c, "pupil1", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table score (snum char(16) primary key, kor integer, " +
                    "eng integer, math integer, total integer, avg double);");
            db.execSQL("create table info (snum char(16) primary key, name char(12), age integer, " +
                    "tel char(20), sex char(8));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists socre;");
            db.execSQL("drop table if exists info;");
            onCreate(db);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snum = (EditText) findViewById(R.id.snumber);
        kor = (EditText) findViewById(R.id.korean);
        eng = (EditText) findViewById(R.id.english);
        mat = (EditText) findViewById(R.id.math);
        input = (EditText) findViewById(R.id.input);
        snum1 = (EditText) findViewById(R.id.snumber1);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        tel = (EditText) findViewById(R.id.tel);
        sex = (EditText) findViewById(R.id.sex);

        te = (TextView) findViewById(R.id.text);

        in = (Button) findViewById(R.id.insert);
        se = (Button) findViewById(R.id.select);
        up = (Button) findViewById(R.id.update);
        de = (Button) findViewById(R.id.delete);
        sh = (Button) findViewById(R.id.show);
        in1 = (Button) findViewById(R.id.insert1);
        se1 = (Button) findViewById(R.id.select1);
        de1 = (Button) findViewById(R.id.delete1);
        up1 = (Button) findViewById(R.id.update1);

        mh = new myHelper(this);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.insert:
                        int k = Integer.parseInt(kor.getText().toString());
                        int e = Integer.parseInt(eng.getText().toString());
                        int m = Integer.parseInt(mat.getText().toString());

                        dbase = mh.getWritableDatabase();
                        sql = "insert into score values ('" +
                                snum.getText().toString() + "', " + k + ", " + e + ", " + m +
                                ", 0, 0);";
                        dbase.execSQL(sql);
                        te.setText(sql);
                        dbase.close();

                        break;

                    case R.id.select:
                        dbase = mh.getReadableDatabase();
                        sql = "select * from score order by snum;";
                        cursor = dbase.rawQuery(sql, null);
                        String res = "";
                        while (cursor.moveToNext()){
                            res = res + cursor.getString(0) + " " + cursor.getString(1) + " ";
                            res = res + cursor.getString(2) + " " + cursor.getString(3) + " ";
                            res = res + cursor.getString(4) + " " + cursor.getString(5) + "\n";

                        }
                        te.setText(res);
                        dbase.close();
                        break;

                    case R.id.update:
                        dbase = mh.getWritableDatabase();
                        sql = "update score set total = kor + eng + math;";
                        dbase.execSQL(sql);
                        sql = "update score set avg = total / 3.0;";
                        dbase.execSQL(sql);
                        te.setText("총점, 평균 계산 완료");
                        dbase.close();
                        break;

                    case R.id.delete:
                        dbase = mh.getWritableDatabase();
                        sql = "delete from score where snum = '" + snum.getText().toString() + "';";
                        dbase.execSQL(sql);
                        te.setText("삭제 완료");
                        dbase.close();
                        break;

                    case R.id.show:
                        dbase = mh.getWritableDatabase();
                        sql = input.getText().toString();
                        cursor = dbase.rawQuery(sql, null);
                        res = "";
                        while (cursor.moveToNext()){
                            res = res + cursor.getString(0) + " " + cursor.getString(1) + " ";
                            res = res + cursor.getString(2) + " " + cursor.getString(3) + " ";
                            res = res + cursor.getString(4) + " " + cursor.getString(5) + " ";
                            res = res + cursor.getString(6) + " " + cursor.getString(7) + " ";
                            res = res + cursor.getString(8) + " " + cursor.getString(9) + " ";
                            res = res + cursor.getString(10) + "\n";

                        }
                        te.setText(res);
                        dbase.close();
                        break;

                    case R.id.insert1:
                        dbase = mh.getWritableDatabase();
                        sql = "insert into info values ('" + snum1.getText().toString() + "', '";
                        sql += name.getText().toString() + "', ";
                        sql += age.getText().toString() + ", '";
                        sql += tel.getText().toString() + "', '";
                        sql += sex.getText().toString() + "');";

                        dbase.execSQL(sql);
                        te.setText(sql);
                        dbase.close();
                        break;

                    case R.id.select1:
                        dbase = mh.getReadableDatabase();
                        sql = "select * from info;";
                        cursor = dbase.rawQuery(sql, null);
                        res = "";
                        while (cursor.moveToNext()){
                            res = res + cursor.getString(0) + " " + cursor.getString(1) + " ";
                            res = res + cursor.getString(2) + " " + cursor.getString(3) + " ";
                            res = res + cursor.getString(4) + "\n";

                        }
                        te.setText(res);
                        dbase.close();
                        break;

                    case R.id.delete1:
                        dbase = mh.getWritableDatabase();
                        sql = "delete from info where snum = '" + snum1.getText().toString() + "';";
                        dbase.execSQL(sql);
                        te.setText("삭제 완료");
                        dbase.close();
                        break;

                    case R.id.update1:
                        dbase = mh.getWritableDatabase();
                        sql = "update info set age = age + 1;";
                        dbase.execSQL(sql);
                        te.setText(sql);
                        dbase.close();
                        break;

                }
            }
        };

        in.setOnClickListener(cl);
        se.setOnClickListener(cl);
        up.setOnClickListener(cl);
        de.setOnClickListener(cl);
        sh.setOnClickListener(cl);
        in1.setOnClickListener(cl);
        se1.setOnClickListener(cl);
        de1.setOnClickListener(cl);
        up1.setOnClickListener(cl);
    }
}