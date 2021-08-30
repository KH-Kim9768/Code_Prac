package com.example.realapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText e1, e2;
    Button b1, b2;
    DatabaseHelper db;
    setting_login li;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.login_id);
        e2 = (EditText)findViewById(R.id.login_password);
        b1 = (Button) findViewById(R.id.login_button);
        b2 = (Button) findViewById(R.id.join_button);
        li = new setting_login();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean Chkidpass = db.idpassword(id, password);
                if (Chkidpass == true) {
                    Toast.makeText(getApplicationContext(), "로그인 성공",
                            Toast.LENGTH_SHORT).show();
                    Intent i = new Intent();
                    i.putExtra("id", id);
                    setResult(10);

                   finish();
                }
                else
                    Toast.makeText(getApplicationContext(),
                            "아이디 혹은 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);

                }

        });
    }
}