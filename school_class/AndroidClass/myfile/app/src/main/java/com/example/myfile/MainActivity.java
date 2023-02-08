package com.example.myfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText filename, filetext, err;
    Button iread, iwrite, eread, ewrite, idelete, edelete, mkdir;
    View.OnClickListener cl;

    // 파일 관련
    FileInputStream fis;
    FileOutputStream fos;

    byte[] btext;
    String s;
    File[] filearray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filename = (EditText) findViewById(R.id.filename);
        filetext = (EditText) findViewById(R.id.filetext);
        err = (EditText) findViewById(R.id.error);

        iread = (Button) findViewById(R.id.iread);
        iwrite = (Button) findViewById(R.id.iwrite);
        eread = (Button) findViewById(R.id.eread);
        ewrite = (Button) findViewById(R.id.ewrite);
        idelete = (Button) findViewById(R.id.idelete);
        edelete = (Button) findViewById(R.id.edelete);
        mkdir = (Button) findViewById(R.id.mkdir);

        filearray = ContextCompat.getExternalFilesDirs(this, null);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.iwrite:
                        try{
                            err.setText("");
                            fos = openFileOutput(filename.getText().toString(), Context.MODE_PRIVATE);
                            fos.write(filetext.getText().toString().getBytes());
                            filetext.setText("");
                            fos.close();
                        } catch(Exception e){
                            err.setText(e.getMessage());
                        }
                        break;

                    case R.id.iread:
                        try{
                            fis = openFileInput(filename.getText().toString());
                            btext = new byte[fis.available()];
                            fis.read(btext);
                            s = new String(btext);
                            filetext.setText(s);
                            fis.close();
                        } catch(Exception e){
                            err.setText(e.getMessage());
                        }
                        break;

                    case R.id.ewrite:
                        try{
                            String wfn = filearray[0].getAbsolutePath() + "/" + filename.getText().toString();
                            err.setText(wfn);
                            fos = new FileOutputStream(wfn);
                            fos.write(filetext.getText().toString().getBytes());
                            fos.close();
                        } catch(Exception e) {
                            err.setText(e.getMessage());

                        }
                        break;

                    case R.id.eread:
                        try{
                            String rfn = filearray[0].getAbsolutePath() + "/" + filename.getText().toString();
                            err.setText(rfn);
                            fis = new FileInputStream(rfn);
                            btext = new byte[fis.available()];
                            fis.read(btext);
                            s = new String(btext);
                            filetext.setText(s);
                            fis.close();
                        } catch(Exception e){
                            err.setText(e.getMessage());
                        }
                        break;

                    case R.id.idelete:
                        try{
                            deleteFile(filename.getText().toString());
                        } catch (Exception e){
                            err.setText(e.getMessage());
                        }
                        break;

                    case R.id.edelete:
                        try{
                            String dfn = filearray[0].getAbsolutePath() + "/" + filename.getText().toString();
//                            File f;
//                            f = new File(dfn);
//                            f.delete();
                            deleteFile(dfn);
                        } catch(Exception e){
                            err.setText(e.getMessage());
                        }
                        break;

                    case R.id.mkdir:
                        try{
                            String mdn = filearray[0].getAbsolutePath() + "/" + filename.getText().toString();
                            File f;
                            f = new File(mdn);
                            f.mkdir();
                        } catch (Exception e){
                            err.setText(e.getMessage());
                        }

                }
            }
        };

        iread.setOnClickListener(cl);
        iwrite.setOnClickListener(cl);
        eread.setOnClickListener(cl);
        ewrite.setOnClickListener(cl);
        idelete.setOnClickListener(cl);
        edelete.setOnClickListener(cl);
        mkdir.setOnClickListener(cl);
    }
}