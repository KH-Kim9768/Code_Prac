package com.example.multilanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    TextView te;
    Button btn;
    View.OnClickListener cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText) findViewById(R.id.edit);
        te = (TextView) findViewById(R.id.text);
        btn = (Button) findViewById(R.id.hello);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText(R.string.mytext);
                te.setText(R.string.myname);
            }
        };

        btn.setOnClickListener(cl);

    }
}