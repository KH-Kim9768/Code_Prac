package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    MyItem mi;
    ArrayList<MyItem> myData;
    MyAdapter adap;


    class MyItem{
        int icon;
        String comment;
        int price;
        float rate;

        MyItem(int icon, String comment, int price, float rate){
            this.icon = icon;
            this.comment = comment;
            this.price = price;
            this.rate = rate;
        }
    }

    class MyAdapter extends BaseAdapter{
        Context con;
        MyAdapter(Context c){
            con = c;
        }

        @Override
        public int getCount() {
            return myData.size();
        }

        @Override
        public Object getItem(int position) {
            return myData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null){
                convertView = ((LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item, parent, false);
            }

            ((ImageView)convertView.findViewById(R.id.image)).setImageResource(myData.get(position).icon);
            ((TextView)convertView.findViewById(R.id.text)).setText(myData.get(position).comment);
            ((EditText) convertView.findViewById(R.id.price)).setText("가격 : " + myData.get(position).price);
            ((RatingBar) convertView.findViewById(R.id.rating)).setRating(myData.get(position).rate);
            View.OnClickListener cl;
            cl = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), myData.get(position).comment + "\n" + myData.get(position).price, Toast.LENGTH_LONG).show();
                }
            };
            ((Button)convertView.findViewById(R.id.buy)).setOnClickListener(cl);

            return convertView;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myData = new ArrayList<MyItem>();

        mi = new MyItem(R.drawable.samsungref, "삼성 냉장고입니다\n 양문형 850리터입니다.", 3500000, 4.5f);
        myData.add(mi);

        mi = new MyItem(R.drawable.lgdrum, "LG 드럼세탁기입니다.\n 15kg까지 세탁 가능합니다.", 2000000, 4.0f);
        myData.add(mi);

        mi = new MyItem(R.drawable.samsungtv, "삼성 TV입니다. \n 85인치 UHD TV입니다.", 2500000, 5.0f);
        myData.add(mi);

        mi = new MyItem(R.drawable.samsungcom, "삼성 컴퓨터입니다. \n 최신 사양입니다.", 1400000, 4.5f);
        myData.add(mi);

        mi = new MyItem(R.drawable.lgair, "LG 공기청정기입니다. \n 공기가 깨끗해집니다.", 900000, 3.5f);
        myData.add(mi);

        mi = new MyItem(R.drawable.lgvacuum, "LG 청소기입니다. \n 무선으로 청소 가능합니다.", 800000, 4.0f);
        myData.add(mi);

        list = (ListView) findViewById(R.id.mylist);
        adap = new MyAdapter(this);
        list.setAdapter(adap);


    }
}