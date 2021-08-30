package com.example.parentchild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;



public class minus2 extends Activity {
    TextView res;
    Button end3, end4;
    double dn1, dn2, dn3;
    View.OnClickListener cl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minus2);

        res = (TextView) findViewById(R.id.result2);
        end3 = (Button) findViewById(R.id.end3);
        end4 = (Button) findViewById(R.id.end4);

        Intent iii;
        iii = getIntent();
        dn1 = iii.getDoubleExtra("dnum1", 0);
        dn2 = iii.getDoubleExtra("dnum2", 1);
        dn3 = dn1 - dn2;
        res.setText("실수 뺄셈 결과 : " + dn3);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ri;
                ri = new Intent();

                switch(view.getId()){
                    case R.id.end3:
                        ri.putExtra("dmult", dn1*dn2);
                        setResult(70, ri);
                        finish();
                        break;

                    case R.id.end4:
                        ri.putExtra("ddiv", dn1/dn2);
                        setResult(80, ri);
                        finish();
                        break;
                }
            }
        };

        end3.setOnClickListener(cl);
        end4.setOnClickListener(cl);

    }
}
