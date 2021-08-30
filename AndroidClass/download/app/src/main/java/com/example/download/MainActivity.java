package com.example.download;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText addr;
    TextView te;
    Button go;
    View.OnClickListener cl;
    WebView wv;
    String page = "";
    String ustring = "";
    MyHandler mh;
    MyThread mt;
    class MyClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            HttpURLConnection conn = null;
            try{
                URL url = new URL(ustring);
                conn = (HttpURLConnection) url.openConnection();
                BufferedInputStream buf;
                buf = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader;
                reader = new BufferedReader(new InputStreamReader(buf));
                String line = null;
                while((line = reader.readLine()) != null){
                    page = page + line + "\n";
                }
                mh.sendEmptyMessage(1);
            } catch (Exception e){
                page = e.getMessage();
                mh.sendEmptyMessage(1);
            }
        }
    }

    class MyHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                te.setText(page);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addr = (EditText) findViewById(R.id.address);
        go = (Button) findViewById(R.id.go);
        te = (TextView) findViewById(R.id.text);
        wv = (WebView) findViewById(R.id.web);
        wv.setWebViewClient(new MyClient());

        mh = new MyHandler();

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page = "";
                wv.loadUrl(addr.getText().toString());
                ustring = addr.getText().toString();
                mt = new MyThread();
                mt.start();
            }
        };

        go.setOnClickListener(cl);

    }
}