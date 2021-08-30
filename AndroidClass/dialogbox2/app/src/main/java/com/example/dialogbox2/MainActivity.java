package com.example.dialogbox2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button dbox1, dbox2;
    EditText res;
    View.OnClickListener cl;
    AlertDialog.Builder dlg;
    DialogInterface.OnClickListener fru1, fru2, yes, no;
    String[] fruit;
    int choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruit = new String[5];
        fruit[0] = "포도";
        fruit[1] = "사과";
        fruit[2] = "바나나";
        fruit[3] = "딸기";
        fruit[4] = "참외";

        dbox1 = (Button) findViewById(R.id.dbox1);
        dbox2 = (Button) findViewById(R.id.dbox2);
        res = (EditText) findViewById(R.id.result);

        fru1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                res.setText("당신이 좋아하는 과일은 " + fruit[which]);
            }
        };

        fru2 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = which;
            }
        };

        yes = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                res.setText("당신이 좋아하는 과일은 " + fruit[choice]);
            }
        };

        no = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                res.setText("");
            }
        };

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.dbox1:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("당신이 좋아하는 과일은?");
                        dlg.setItems(fruit, fru1);
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.show();
                        break;


                    case R.id.dbox2:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("당신이 좋아하는 과일은?");
                        dlg.setSingleChoiceItems(fruit, 0, fru2);
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.setPositiveButton("선택 완료", yes);
                        dlg.setNegativeButton("취소", no);
                        dlg.show();
                        break;

                }
            }
        };

        dbox1.setOnClickListener(cl);
        dbox2.setOnClickListener(cl);




    }
}