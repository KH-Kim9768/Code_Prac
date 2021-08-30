package com.example.test_loading;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    Button getbtn;
    TextView text, fout, jout;
    String page = "";
    String s;

    JSONObject json;


    FileInputStream fis;
    FileOutputStream fos;

    byte[] btext;



    MyHandler mh;
    protected void loading() {
        // Storage에서 Hash 읽어옴 >> Hash, id를 Server-autologin에 보냄 --> return 에러가 없으면 >> main
        // return 에러가 있거나 Exception 발생 시 login
        /*
        try {
            fis = openFileInput("logon.txt");
            btext = new byte[fis.available()];
            fis.read(btext);
            s = new String(btext);
            loading();
        } catch (Exception e) {
            s = e.getMessage();
            mh.sendEmptyMessage(1);
        }
        */
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            HttpURLConnection conn = null;
            try{
                URL url = new URL("http://project-geek.cc/hello");
                conn = (HttpURLConnection) url.openConnection();
                BufferedInputStream buf;
                buf = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader;
                reader = new BufferedReader(new InputStreamReader(buf));
                String line = null;
                while((line = reader.readLine())!= null){
                    page = page + line + "\n";
                }
                mh.sendEmptyMessage(1);

                // 파일 저장(쓰기)
                fos = openFileOutput("logon.json", MODE_PRIVATE);
                fos.write(page.getBytes());
                fos.close();

                // 파일 읽기
                fis = openFileInput("logon.json");
                btext = new byte[fis.available()];
                fis.read(btext);
                s = new String(btext);
                fout.setText(s);
                fis.close();

                // JSON String 토큰화
                json = (JSONObject) new JSONTokener(s).nextValue();
                jout.setText(json.getString("hello"));



            } catch(Exception e){
                page = e.getMessage();
                mh.sendEmptyMessage(1);
            }
        }
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                text.setText(page);
            }
        }
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getbtn = (Button) findViewById(R.id.get);
        text = (TextView) findViewById(R.id.text);
        jout = (TextView) findViewById(R.id.textjson);
        fout = (TextView) findViewById(R.id.fileout);

        mh = new MyHandler();

        getbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page = "";
                MyThread mt = new MyThread();
                mt.start();

            }
        });
    }
}