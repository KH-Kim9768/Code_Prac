package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] ver = {"apple", "banana", "cupcake", "donut", "eclair", "froyo", "gingerbread",
                "honeycomb", "icecream sandwitch", "jellybean", "kitkat", "lolipop",
                "marshmallow", "nougat", "oreo", "pie", "q", "r"};
    ArrayAdapter<String> adap;
    EditText te;
    ArrayList<String> fruit;
    Button ins, del;
    View.OnClickListener cl;
    int sel = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        te = (EditText) findViewById(R.id.text);
        ins = (Button) findViewById(R.id.insert);
        del = (Button) findViewById(R.id.delete);
        fruit = new ArrayList<String>();
        fruit.add("사과");
        fruit.add("딸기");
        list = (ListView) findViewById(R.id.version);
//        adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ver);
        adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, fruit);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setAdapter(adap);
//        list.setItemChecked(2, true);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                te.setText("당신의 버전은 " + ver[i]);
                te.setText("당신이 좋아하는 과일은 " + fruit.get(i));
                sel = i;
            }
        });

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.insert:
                        fruit.add(te.getText().toString());
                        adap.notifyDataSetChanged();
                        break;

                    case R.id.delete:
                        if(sel >= 0) {
                            fruit.remove(sel);
                            adap.notifyDataSetChanged();
                            list.clearChoices();
                        }
                        break;
                }
            }
        };

        ins.setOnClickListener(cl);
        del.setOnClickListener(cl);

    }
}