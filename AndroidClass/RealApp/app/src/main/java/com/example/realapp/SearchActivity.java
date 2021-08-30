package com.example.realapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class SearchActivity extends AppCompatActivity {


    Intent i;
    EditText editTextFilter;
    ListViewAdapter adapter;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;
    CheckBox onetimechk;
    Button nametab, maptab;
    SearchName searchName;
    SearchMap searchMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        setTitle("검색 결과");
        editTextFilter = (EditText) findViewById(R.id.editTextFilter);
        onetimechk = (CheckBox) findViewById(R.id.onetimechk);
        nametab = (Button) findViewById(R.id.nametab);
        maptab = (Button) findViewById(R.id.maptab);
        searchName = new SearchName();
        searchMap = new SearchMap();
        getSupportFragmentManager().beginTransaction().replace(
                R.id.search_layout, searchName).commitAllowingStateLoss();


        // 인텐트 받아오기
        i = getIntent();
        String query = i.getStringExtra("query");
        editTextFilter.setText(query);

        searchName.setEditTextFilter(editTextFilter);
        searchName.setOneTimeChk(onetimechk);
        searchMap.setEditTextFilter(editTextFilter);
        searchMap.setOneTimeChk(onetimechk);

        // listView 참조 및 Adapter 담기
        adapter = new ListViewAdapter();
        adapter.setChkbox(onetimechk);  // 체크박스 adapter에 넘겨주기


        searchName.setAdapter(adapter);


        // 리스트뷰 셋팅
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        String sql = "select * from meet;";
        cursor = db.rawQuery(sql, null);
        String title, desc, lat, lon, oneT;
        while(cursor.moveToNext()){
            title = cursor.getString(0);
            desc = cursor.getString(1);
            lat = cursor.getString(2);
            lon = cursor.getString(3);
            oneT = cursor.getString(4);
            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.main_mygroup_icon), title, desc,
                    lat, lon, oneT);
        }
        db.close();




        // Fragment 화면 전환

        nametab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.search_layout, searchName).commitAllowingStateLoss();
            }
        });

//        maptab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getSupportFragmentManager().beginTransaction().replace(
//                        R.id.search_layout, searchMap).commitAllowingStateLoss();
//            }
//        });



    }
}
