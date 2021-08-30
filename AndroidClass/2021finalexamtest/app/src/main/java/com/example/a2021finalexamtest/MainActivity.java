package com.example.a2021finalexamtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myview;
    ArrayList<MyItem> mylist;
    MyAdapter adapter;

    class MyItem {
        int icon;
        String text;
        int price;

        MyItem(int ic, String te, int pr){
            icon = ic;
            text = te;
            price = pr;
        }
    }

    class MyAdapter extends BaseAdapter{
        Context ctx;
        MyAdapter(Context c){
            ctx = c;
        }


        @Override
        public int getCount() {
            return mylist.size();
        }

        @Override
        public Object getItem(int position) {
            return mylist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView img;
            TextView tv;
            EditText pr;

            if (convertView == null) {
                convertView = ((LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.myitem, parent, false);
            }
            img = (ImageView)convertView.findViewById(R.id.myimage);
            img.setImageResource(mylist.get(position).icon);

            tv = (TextView)convertView.findViewById(R.id.mytext);
            tv.setText(mylist.get(position).text);

            pr = (EditText)convertView.findViewById(R.id.myprice);
            pr.setText(mylist.get(position).price+"");

            return convertView;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylist = new ArrayList<MyItem>();
        MyItem item;
        item = new MyItem(R.drawable.ic_launcher_background, "대우 텔레비전", 750000);
        mylist.add(item);
        item = new MyItem(R.drawable.ic_launcher_foreground, "LG 트롬 세탁기", 850000);
        mylist.add(item);
        item = new MyItem(R.drawable.ic_launcher_foreground, "삼성 지펠 냉장고", 920000);
        mylist.add(item);

        adapter = new MyAdapter(this);
        myview = (ListView) findViewById(R.id.listview);
        myview.setAdapter(adapter);

    }
}