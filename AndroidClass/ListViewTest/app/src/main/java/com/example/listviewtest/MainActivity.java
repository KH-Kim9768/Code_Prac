package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText item;
    Button btn;
    View.OnClickListener cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("리스트뷰 테스트");

        item = (EditText) findViewById(R.id.edtItem);
        btn = (Button) findViewById(R.id.btnAdd);

//        final String[] mid = {
//                "히어로즈", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크", "빅뱅이론", "프렌즈", "덱스터", "글리", "가쉽걸"
//        };
        final ArrayList<String> midList = new ArrayList<String>();


        ListView list = (ListView) findViewById(R.id.listview1);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, midList);
        list.setAdapter(adapter);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.btnAdd:
                        midList.add(item.getText().toString());
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        };

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){
                midList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
//                Toast.makeText(getApplicationContext(), mid[arg2], Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(cl);
    }
}