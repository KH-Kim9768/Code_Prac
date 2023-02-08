package com.example.parentchild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class minus extends Activity {
    TextView mres;
    Button end, end2;
    View.OnClickListener cl;
    Intent ii;
    int n1, n2, res;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minus);

        mres = (TextView) findViewById(R.id.minusresult);
        end = (Button) findViewById(R.id.end1);
        end2 = (Button) findViewById(R.id.end2);

        ii = getIntent();
        n1 = ii.getIntExtra("num1", 0);
        n2 = ii.getIntExtra("num2", 0);
        res = n1-n2;
        mres.setText("뺄셈 결과 : " + res);
        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ri;
                ri = new Intent();

                switch(view.getId()){

                    case R.id.end1:
                        ri.putExtra("mult", n1*n2);
                        setResult(50, ri);
                        finish();
                        break;

                    case R.id.end2:
                        double num3 = n1/n2;
                        ri.putExtra("div", num3);
                        setResult(60, ri);
                        finish();
                        break;
                }
            }
        };

        end.setOnClickListener(cl);
        end2.setOnClickListener(cl);
    }
}
