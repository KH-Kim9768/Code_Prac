package com.example.compute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class subtract extends Activity {
    EditText subres;
    Button end;
    int n1, n2, n3;
    View.OnClickListener cl;
    Intent i;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        subres = (EditText) findViewById(R.id.subresult);
        end = (Button) findViewById(R.id.end);

        i = getIntent();
        n1 = i.getIntExtra("num1", 0);
        n2 = i.getIntExtra("num2", 0);
        n3 = n1-n2;

        subres.setText("뺄셈 결과 : " + n3);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.end:
                        finish();
                        break;
                }
            }
        };

        end.setOnClickListener(cl);


    }
}
