package com.example.httptest;


import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class HttpHandler {
    TextView tvResult;

    public Handler handler;

    private String urlString;


    public HttpHandler(TextView tvResult, String urlString){
        this.tvResult = tvResult;
        this.urlString = urlString;
    }

    public void callGetMethod(){
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                String resultMsg = msg.getData().getString("result");

                // 결과가 없을 경우
                if (resultMsg == null) {
                    resultMsg = "Handler Said : No Return";
                }

                // 화면에 표시
                tvResult.setText(resultMsg);
            }
        };

        HttpConnection httpConnection = new HttpConnection(handler, urlString);
        httpConnection.RequestGetMethod();

    }





}
