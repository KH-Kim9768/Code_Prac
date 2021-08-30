package com.example.compute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView res;
    Button add, min, mul;
    View.OnClickListener cl;
    int n1, n2, n3;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        res = (TextView) findViewById(R.id.result);
        min = (Button) findViewById(R.id.minus);
        add = (Button) findViewById(R.id.add);
        mul = (Button) findViewById(R.id.multi);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.add:
                        n1 = Integer.parseInt(num1.getText().toString());
                        n2 = Integer.parseInt(num2.getText().toString());
                        n3 = n1 + n2;
                        res.setText("덧셈 결과 : " + n3);
                        break;

                    case R.id.minus:
                        n1 = Integer.parseInt(num1.getText().toString());
                        n2 = Integer.parseInt(num2.getText().toString());
                        i = new Intent(getApplicationContext(), subtract.class);
                        i.putExtra("num1", n1);
                        i.putExtra("num2", n2);
                        startActivity(i);
                        break;

                    case R.id.multi:
                        i = new Intent(getApplicationContext(), multi.class);
                        i.putExtra("num1", num1.getText().toString());
                        i.putExtra("num2", num2.getText().toString());
                        startActivity(i);
                        break;
                }
            }
        };

        add.setOnClickListener(cl);
        min.setOnClickListener(cl);
        mul.setOnClickListener(cl);
    }
}