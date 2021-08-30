package com.example.realapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(id text primary key, password text);");
        db.execSQL("Create table meet(title text, description text, latitude text, longitude text, onetime text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table meet if exists meet");
        db.execSQL("drop table user");
        onCreate(db);
    }

    public boolean insert(String id, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        db.close();
        if (ins == -1) return false;
        else return  true;
    }

    public boolean meetInsert(String title, String desc, String latitude, String longitude, boolean onetime){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("description", desc);
        contentValues.put("latitude", latitude);
        contentValues.put("longitude", longitude);
        if (onetime){
            String yes = "y";
            contentValues.put("onetime", yes);
        } else{
            String no = "n";
            contentValues.put("onetime", no);
        }
        long ins = db.insert("meet", null, contentValues); // 오류 있을 시 -1 return
        db.close();
        if (ins == -1) return false;
        else return true;
    }

    public Boolean chkid(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where id=?", new String[]{id});
        if (cursor.getCount() > 0) return false;
        else return true;
    }

    public Boolean idpassword(String id, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where id=? and password=?", new String[]{id, password});
        if (cursor.getCount() > 0) return true;
        else return false;
    }
}

