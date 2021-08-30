package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gv;
    int[] pic = {R.drawable.black, R.drawable.green, R.drawable.orange,
            R.drawable.red, R.drawable.yellow, R.drawable.blue, R.drawable.brown, R.drawable.cyan, R.drawable.gray, R.drawable.purple};
    MyAdapter adap;
    AdapterView.OnItemClickListener icl;
    ImageView iv;


    class MyAdapter extends BaseAdapter{
        Context con;

        MyAdapter(Context c){
            con = c;
        }

        @Override
        public int getCount() {
            return pic.length;
        }

        @Override
        public Object getItem(int position) {
            ImageView iv;
            iv = new ImageView(con);
            iv.setImageResource(pic[position]);
            return iv;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if ( convertView == null ) {
                convertView = new ImageView(con);

            }
            ((ImageView) convertView).setImageResource(pic[position]);

            return convertView;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.imageView);
        gv = (GridView) findViewById(R.id.picture);
        adap = new MyAdapter(this);

        gv.setAdapter(adap);

        icl = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                iv.setImageResource(pic[position]);
                Toast.makeText(getApplicationContext(), "index = " + position, Toast.LENGTH_LONG).show();
            }
        };

        gv.setOnItemClickListener(icl);
    }
}