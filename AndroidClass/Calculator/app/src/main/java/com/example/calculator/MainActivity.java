package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText n1,n2;
    Button ad,su,mu,di;
    TextView re;
    View.OnClickListener cl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = (EditText) findViewById(R.id.num1);
        n2 = (EditText) findViewById(R.id.num2);

        ad = (Button) findViewById(R.id.add);
        su = (Button) findViewById(R.id.sub);
        mu = (Button) findViewById(R.id.mul);
        di = (Button) findViewById(R.id.div);

        re = (TextView) findViewById(R.id.result);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int a, b;
                double a, b, c;
                if (n1.getText().toString().length() == 0){ // .length는 길이. 1이면 1, 12면 2, null이면 0
                    n1.setText("0");
                }

                if (n2.getText().toString().length() == 0){
                    n2.setText("0");
                }


//                a = Integer.parseInt(n1.getText().toString());
//                b = Integer.parseInt(n2.getText().toString());

                a= Double.parseDouble(n1.getText().toString());
                b= Double.parseDouble(n2.getText().toString());


                switch( v.getId()){
                    case R.id.add:
                        c = a+b;
                        re.setText(String.valueOf(c)); // 문자열로 변환해야 오류없음
                        break;
                    case R.id.sub:
                        c = a-b;
                        re.setText(c+""); // 이것도 문자열로 바뀜
                        break;
                    case R.id.mul:
                        c = a*b;
                        re.setText(c+"");
                        break;
                    case R.id.div:
                        if(b==0){
                            re.setText("분모가 0이에요.");
                        } else {
                            c = a / b;
                            re.setText("" + c); // 이것도 문자열로 바뀜
                            break;
                        }

                }
            }
        };

        ad.setOnClickListener(cl);
        su.setOnClickListener(cl);
        mu.setOnClickListener(cl);
        di.setOnClickListener(cl);


    }
}