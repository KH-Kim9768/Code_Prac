package com.example.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText address;
    Button run, bw, fw;
    WebView show;
    View.OnClickListener cl;
    View.OnKeyListener kl;

    class myClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        address = (EditText) findViewById(R.id.address);
        run = (Button) findViewById(R.id.run);
        bw = (Button) findViewById(R.id.backward);
        fw = (Button) findViewById(R.id.forward);
        show = (WebView) findViewById(R.id.show);
        WebSettings set;
        set = show.getSettings();
        set.setJavaScriptEnabled(true);
        set.setBuiltInZoomControls(true);

        show.setWebViewClient(new myClient());

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.run :
                        show.loadUrl(address.getText().toString());
                        break;

                    case R.id.backward :
                        show.goBack();
                        break;

                    case R.id.forward :
                        show.goForward();
                        break;
                }
            }
        };

        kl = new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ( keyCode == KeyEvent.KEYCODE_ENTER) {
                    show.loadUrl(address.getText().toString());
                }
                return false;
            }
        };

        address.setOnKeyListener(kl);

        run.setOnClickListener(cl);
        bw.setOnClickListener(cl);
        fw.setOnClickListener(cl);

    }
}