package com.example.adapterview;

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

    ListView lv;
    String[] version = {"Jellybean", "kitkat", "Lollipop", "Marshmellow", "Nouga", "Oreo", "Pie", "Q", "R"};
    ArrayAdapter<String> adap;
    AdapterView.OnItemClickListener icl;
    View.OnClickListener cl;

    ArrayList<String> General;

    Button ins, del;
    EditText te;

    int choice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ins = (Button) findViewById(R.id.insert);
        del = (Button) findViewById(R.id.delete);
        te = (EditText) findViewById(R.id.text);

        General = new ArrayList<String>();
        General.add("강감찬");
        General.add("이순신");
        General.add("김유신");



        lv = (ListView) findViewById(R.id.show);
//        adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, version);
        adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, General);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setAdapter(adap);

        icl = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                choice = position;
                Toast.makeText(getApplicationContext(), "index = " + position + " 장군 = " + General.get(position), Toast.LENGTH_LONG).show();
            }
        };

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.insert:
                        General.add(te.getText().toString());
                        adap.notifyDataSetChanged();
                        break;

                    case R.id.delete:
                        General.remove(choice);
                        adap.notifyDataSetChanged();
                        lv.clearChoices();
                        break;
                }
            }
        };

        lv.setOnItemClickListener(icl);
        ins.setOnClickListener(cl);
        del.setOnClickListener(cl);

    }
}