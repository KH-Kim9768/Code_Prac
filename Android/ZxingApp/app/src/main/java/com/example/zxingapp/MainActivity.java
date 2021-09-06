package com.example.zxingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    private Button startBtn;
    private TextView ResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.startDecodeBtn);
        ResultTextView = (TextView) findViewById(R.id.resultTextView);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (hasCamera()) {
                        IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                        integrator.setCaptureActivity(CustomScannerActivity.class);
                        integrator.initiateScan();
                    } else {
                        Toast.makeText(getApplicationContext(), "카메라가 없습니다", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e){
                    ResultTextView.setText(e.getMessage());
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode == Activity.RESULT_OK){
            IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            String type = scanResult.getFormatName();
            String result = scanResult.getContents();
            ResultTextView.setText("Type = " + type + ", String = " + result);
        } else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private boolean hasCamera(){
        return getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }
}