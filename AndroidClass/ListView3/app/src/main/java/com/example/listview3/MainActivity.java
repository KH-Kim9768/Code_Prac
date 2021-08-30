package com.example.listview3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("커스텀 리스트뷰 예제");

        adapter = new ListViewAdapter();    // Adapter 생성

        // listView 참조 및 Adapter 담기
        listView = (ListView) findViewById(R.id.listview1);
        listView.setAdapter(adapter);

        // 데이터 추가 부분
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.baseline_account_box_black_36dp),
                "Box", "Account Box Black 36dp");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.baseline_account_circle_black_36dp),
                "Circle", "Account Circle Black 36dp");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.baseline_account_box_black_36dp_s),
                "Small Box", "Account Box Black 36dp Small Ver");

        // 아이템 클릭 이벤트 처리 함수
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                //get Item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                String descStr = item.getDesc();
                Drawable iconDrable = item.getIcon();
                // TODO : use item data
            }
        });
    }
}