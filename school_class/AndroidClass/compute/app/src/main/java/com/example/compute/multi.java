package com.example.compute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class multi extends Activity {

    TextView mres;
    Button end, div;
    View.OnClickListener cl;
    Intent i;
    int n1, n2, n3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mul);

        mres = (TextView) findViewById(R.id.multresult);
        end = (Button) findViewById(R.id.mulend);
        div = (Button) findViewById(R.id.div);

        i = getIntent();
        if(i.getStringExtra("num1") != null){
            n1 = Integer.parseInt(i.getStringExtra("num1"));
            n2 = Integer.parseInt(i.getStringExtra("num2"));
            n3 = n1 * n2;

            mres.setText("곱셈 결과 : " + n3);
        }


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.mulend:
                        finish();
                        break;

                    case R.id.div:
                        i = new Intent(getApplicationContext(), division.class);
                        i.putExtra("num1", n1);
                        i.putExtra("num2", n2);
                        startActivity(i);
                        break;
                }

            }
        };

        end.setOnClickListener(cl);
        div.setOnClickListener(cl);
    }
}
