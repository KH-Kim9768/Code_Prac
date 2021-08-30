package com.example.compute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class division extends Activity {
    TextView divres;
    Button end;
    View.OnClickListener cl;
    Intent i;
    int n1, n2;
    double n3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.div);

        divres = (TextView) findViewById(R.id.divresult);
        end = (Button) findViewById(R.id.divend);

        i = getIntent();
        n1 = i.getIntExtra("num1", 0);
        n2 = i.getIntExtra("num2", 1);
        n3 = n1/n2;

        divres.setText("나눗셈 결과 : " + n3);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.divend:
                        finish();
                        break;
                }
            }
        };

        end.setOnClickListener(cl);


    }
}
