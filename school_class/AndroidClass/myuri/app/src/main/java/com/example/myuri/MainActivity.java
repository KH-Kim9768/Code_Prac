package com.example.myuri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText te;
    Button ru, ri, ma, ge;
    View.OnClickListener cl;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        te = (EditText) findViewById(R.id.text);
        ru = (Button) findViewById(R.id.run);
        ri = (Button) findViewById(R.id.ring);
        ma = (Button) findViewById(R.id.mail);
        ge = (Button) findViewById(R.id.geo);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.run:
                        i = new Intent();
                        i.setAction(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(te.getText().toString()));
                        startActivity(i);
                        break;

                    case R.id.ring:
                        i = new Intent();
                        i.setAction(Intent.ACTION_VIEW);
                        i.setData(Uri.parse("tel:" + te.getText().toString()));
                        startActivity(i);
                        break;

                    case R.id.mail:
                        i = new Intent();
                        i.setAction(Intent.ACTION_VIEW);
                        i.setData(Uri.parse("mailto:" + te.getText().toString()));
                        startActivity(i);
                        break;

                    case R.id.geo:
                        i = new Intent();
                        i.setAction(Intent.ACTION_VIEW);
                        i.setData(Uri.parse("geo:" + te.getText().toString()));
                        startActivity(i);
                        break;
                }
            }
        };

        ru.setOnClickListener(cl);
        ri.setOnClickListener(cl);
        ma.setOnClickListener(cl);
        ge.setOnClickListener(cl);
    }
}