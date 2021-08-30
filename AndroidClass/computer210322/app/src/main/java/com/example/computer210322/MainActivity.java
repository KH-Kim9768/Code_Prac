package com.example.computer210322;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button add, mul, min, div;
    TextView res;
    View.OnClickListener cl;

    double n1, n2, n3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.number1);
        num2 = (EditText) findViewById(R.id.number2);

        add = (Button) findViewById(R.id.add);
        min = (Button) findViewById(R.id.minus);
        mul = (Button) findViewById(R.id.multiply);
        div = (Button) findViewById(R.id.division);

        res = (TextView) findViewById(R.id.result);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.add:
                        try{
                            n1 = Double.parseDouble(num1.getText().toString());
                            n2 = Double.parseDouble(num2.getText().toString());

                            n3 = n1 + n2;
                            res.setText(n3 + "");
//                        res.setText(String.valueOf(n3));
                        } catch (Exception e){
                            res.setText(e.getMessage());
                        }


                        break;

                    case R.id.multiply:
                        try{
                            n1 = Double.parseDouble(num1.getText().toString());
                            n2 = Double.parseDouble(num2.getText().toString());

                            n3 = n1 * n2;
                            res.setText(n3 + "");

                        } catch (Exception e){
                            res.setText(e.getMessage());
                        }
                        break;

                    case R.id.minus:
                        try{
                            n1 = Double.parseDouble(num1.getText().toString());
                            n2 = Double.parseDouble(num2.getText().toString());

                            n3 = n1 - n2;
                            res.setText(n3 + "");

                        } catch (Exception e){
                            res.setText(e.getMessage());
                        }
                        break;

                    case R.id.division:
                        try{
                            n1 = Double.parseDouble(num1.getText().toString());
                            n2 = Double.parseDouble(num2.getText().toString());

                            n3 = n1 / n2;
                            res.setText(n3 + "");

                        } catch (Exception e){
                            res.setText(e.getMessage());
                        }
                        break;
                }
            }
        };

        add.setOnClickListener(cl);
        mul.setOnClickListener(cl);
        min.setOnClickListener(cl);
        div.setOnClickListener(cl);
    }
}