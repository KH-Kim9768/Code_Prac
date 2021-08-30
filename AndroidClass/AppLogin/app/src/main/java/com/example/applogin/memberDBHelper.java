package com.example.applogin;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class memberDBHelper extends SQLiteOpenHelper {
    public static final String tableName = "memberTBL";

    public memberDBHelper(Context c, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(c, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db){
//            db.execSQL("CREATE TABLE " + tableName + " (id CHAR(20) PRIMARY KEY, pw CHAR(20), name CHAR(10), nickname CHAR(20))");
        createTable(db);  // db 생성, db 가 없을 때만 최초로 실행함
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public void createTable(SQLiteDatabase db){
        String sql = "CREATE TABLE " + tableName + "(id text PRIMARY KEY, pw text, name text, nickname text);" ;
        try{
            db.execSQL(sql);
        } catch (SQLException e){

        }
    }

    public void insertMember(SQLiteDatabase db, String id, String pw, String name, String nickname){

//        db.beginTransaction();
        try{
            String sql = "INSERT INTO " + tableName + " VALUES ('" + id + "', '" + pw + "', '" + name + "', '" + nickname + "');";
            db.execSQL(sql);
            db.setTransactionSuccessful();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
}
