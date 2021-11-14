package com.example.httptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
https://ju-hy.tistory.com/65

 */
public class MainActivity extends AppCompatActivity {

    EditText edtUrl;
    Button btnGet;
    Button btnPost;
    Button btnPut;
    Button btnDelete;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUrl = findViewById(R.id.edt_url);
        btnGet = findViewById(R.id.btn_get);
        btnPost = findViewById(R.id.btn_post);
        btnPut = findViewById(R.id.btn_put);
        btnDelete = findViewById(R.id.btn_delete);
        tvResult = findViewById(R.id.tv_result);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputUrl = edtUrl.getText().toString();

                HttpHandler httpHandler = new HttpHandler(tvResult, inputUrl);
                httpHandler.callGetMethod();

            }
        });
    }
}