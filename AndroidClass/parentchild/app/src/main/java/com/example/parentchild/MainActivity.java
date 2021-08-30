package com.example.parentchild;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    TextView res;
    Button add, sub, add2, sub2;
    View.OnClickListener cl;
    int n1, n2, n3;
    double dn1, dn2, dn3;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.number1);
        num2 = (EditText) findViewById(R.id.number2);
        res = (TextView) findViewById(R.id.result);
        add = (Button) findViewById(R.id.plus);
        sub = (Button) findViewById(R.id.subtract);
        add2 = (Button) findViewById(R.id.plus2);
        sub2 = (Button) findViewById(R.id.subtract2);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1 = Integer.parseInt(num1.getText().toString());
                n2 = Integer.parseInt(num2.getText().toString());
                dn1 = Double.parseDouble(num1.getText().toString());
                dn2 = Double.parseDouble(num2.getText().toString());

                switch(view.getId()){
                    case R.id.plus:
                        n3 = n1 + n2;
                        res.setText("덧셈 결과 : " + n3);
                        break;

                    case R.id.subtract:
                        i = new Intent(getApplicationContext(), minus.class);
                        i.putExtra("num1", n1);
                        i.putExtra("num2", n2);
                        startActivityForResult(i, 20);
                        break;

                    case R.id.plus2:
                        dn3 = dn1 + dn2;
                        res.setText("실수 덧셈 결과 : " + dn3);
                        break;

                    case R.id.subtract2:
                        i = new Intent(getApplicationContext(), minus2.class);
                        i.putExtra("dnum1", dn1);
                        i.putExtra("dnum2", dn2);
                        startActivityForResult(i, 30);
                        break;
                }
            }
        };

        add.setOnClickListener(cl);
        sub.setOnClickListener(cl);
        add2.setOnClickListener(cl);
        sub2.setOnClickListener(cl);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20){
            if (resultCode == 50){
                res.setText("곱셈 결과 : " + data.getIntExtra("mult", 0));
            }

            if(resultCode == 60){
                res.setText("나눗셈 결과 : " + data.getDoubleExtra("div", 0));
            }
        }

        if (requestCode == 30){
            if (resultCode == 70){
                res.setText("실수 곱셈 결과 : " + data.getDoubleExtra("dmult", 0));
            }

            if (resultCode == 80){
                res.setText("실수 나눗셈 결과 : " + data.getDoubleExtra("ddiv", 0));
            }
        }
    }
}