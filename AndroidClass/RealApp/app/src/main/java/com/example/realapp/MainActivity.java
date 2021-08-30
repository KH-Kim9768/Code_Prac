package com.example.realapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    EditText e1, e2;
    home hm;
    chat ch;
    mygroup mg;
    setting_login li;
    setting_logout lo;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView= findViewById(R.id.bottomNavigationView);
        db = new DatabaseHelper(this);
        hm = new home();
        ch = new chat();
        mg = new mygroup();
        li = new setting_login();
        lo = new setting_logout();





        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,
                hm).commitAllowingStateLoss();
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                         switch (menuItem.getItemId()) {
                            case R.id.tab1: {
                                getSupportFragmentManager().beginTransaction().replace(
                                        R.id.main_layout, hm).commitAllowingStateLoss();
                                return true;
                            }
                            case R.id.tab2: {
                                getSupportFragmentManager().beginTransaction().replace(
                                        R.id.main_layout, mg).commitAllowingStateLoss();
                                return true;
                            }
                            case R.id.tab3: {
                                getSupportFragmentManager().beginTransaction().replace(
                                        R.id.main_layout, ch).commitAllowingStateLoss();
                                return true;
                            }
                            case R.id.tab4: {
                                getSupportFragmentManager().beginTransaction().replace(
                                        R.id.main_layout, li).commitAllowingStateLoss();
                                return true; }

                            default : return false;
                         }

                    }
                });
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        final MenuItem item = menu.findItem(R.id.search_icon);
        SearchView searchView = (SearchView) item.getActionView();

        // 서치뷰 클릭시 자동 포커스
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();

        // 서치뷰 검색어 입력 이벤트
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class); // getAppicationContext()로 해야함 getActivity() 불가
                intent.putExtra("query", query);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        //서치뷰 닫기 버튼 클릭시 이벤트
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                item.collapseActionView();
                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }


}
