package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    int[] pic = {R.drawable.lbs, R.drawable.mim, R.drawable.sms, R.drawable.a1, R.drawable.a2};
    myAdapter adap;
    ImageView iv;
    AdapterView.OnItemClickListener icl;

    class myAdapter extends BaseAdapter{
        Context con;

        myAdapter(Context c){
            con = c;
        }

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int i) {
            ImageView iv;
            iv = new ImageView(con);
            iv.setImageResource(pic[i%5]);
            return iv;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                view = new ImageView(con);

            }

            ((ImageView) view).setImageResource(pic[i%5]);
            return view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = (GridView) findViewById(R.id.picture);
        adap = new myAdapter(this);
        iv = (ImageView) findViewById(R.id.image);
        grid.setAdapter(adap);
        grid.setNumColumns(5);
        grid.setNumColumns(10);

        icl = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                iv.setImageResource(pic[i%5]);
            }
        };
        grid.setOnItemClickListener(icl);
        }
}
