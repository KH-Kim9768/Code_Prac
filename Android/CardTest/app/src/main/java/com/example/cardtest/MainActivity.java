package com.example.cardtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startCard00Btn;
    Button startCard01Btn;

    TextView errView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startCard00Btn = findViewById(R.id.start_card00_btn);
        startCard01Btn = findViewById(R.id.start_card01_btn);
        errView = findViewById(R.id.err_view);

        startCard00Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    startActivity(new Intent(getApplicationContext(), Card00.class));
                } catch (Exception e){
                    errView.setText(e.getMessage());
                }

            }
        });

        startCard01Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Card01.class));
            }
        });
    }
}