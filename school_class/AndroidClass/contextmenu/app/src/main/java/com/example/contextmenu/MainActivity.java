package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    Button he;
    View.OnClickListener cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = (EditText) findViewById(R.id.edit);
        he = (Button) findViewById(R.id.hello);
        registerForContextMenu(edt);
        registerForContextMenu(he);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.hello:
                        edt.setText("안녕하세요");
                        break;
                }
            }
        };

        he.setOnClickListener(cl);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v == edt){
            menu.add(0,301, 0, "노랑색");
            menu.add(0, 302, 0, "하늘색");

            SubMenu smenu;
            smenu = menu.addSubMenu("기타색");
            smenu.add(0, 303, 0, "분홍색");
            smenu.add(0, 304, 0, "검정색");

        } else if(v == he){
            SubMenu smenu;
            smenu = menu.addSubMenu("장군");
            smenu.add(0, 401, 0, "강감찬");
            smenu.add(0, 402, 0, "이순신");
            smenu.add(0, 403, 0, "");
            smenu.add(0, 404, 0, "");

            smenu = menu.addSubMenu("여자 인물");
            smenu.add(0, 501, 0, "유관순");
            smenu.add(0, 502, 0, "신사임당");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 301:
                edt.setBackgroundColor(Color.YELLOW);
                break;

            case 302:
                edt.setBackgroundColor(Color.CYAN);
                break;

            case 303:
                edt.setBackgroundColor(Color.MAGENTA);
                break;

            case 304:
                edt.setBackgroundColor(Color.BLACK);
                break;

            case 401:
                edt.setText("강감찬");
                break;

            case 402:
                edt.setText("이순신");
                break;

            case 501:
                edt.setText("유관순");
                break;

            case 502:
                edt.setText("심사임당");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 101, 0, "빨강색");
        menu.add(0, 102, 0, "녹색");
        menu.add(0, 103, 0, "파랑색");

        SubMenu sm;
        sm = menu.addSubMenu("회색계통");
        sm.add(0, 201, 0, "밝은 회색");
        sm.add(0, 202, 0, "회색");
        sm.add(0, 203, 0, "검은 회색");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 101:
                edt.setBackgroundColor(Color.RED);
                break;

            case 102:
                edt.setBackgroundColor(Color.GREEN);
                break;

            case 103:
                edt.setBackgroundColor(Color.BLUE);
                break;

            case 201:
                edt.setBackgroundColor(Color.LTGRAY);
                break;

            case 202:
                edt.setBackgroundColor(Color.GRAY);
                break;

            case 203:
                edt.setBackgroundColor(Color.DKGRAY);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}