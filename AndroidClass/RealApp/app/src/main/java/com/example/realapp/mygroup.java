package com.example.realapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class mygroup extends Fragment {
    private Context context;
    DatabaseHelper dbHelper;
    ViewGroup viewGroup;
    EditText meettitle, meetdesc, meetlat, meetlon;
    Button meetbtn, dbupdate;
    CheckBox meetonetime;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = container.getContext();
        dbHelper = new DatabaseHelper(context);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.mygroup, container, false);
        meettitle = (EditText) viewGroup.findViewById(R.id.meettitle);
        meetdesc = (EditText) viewGroup.findViewById(R.id.meetdesc);
        meetlat = (EditText) viewGroup.findViewById(R.id.meetlat);
        meetlon = (EditText) viewGroup.findViewById(R.id.meetlon);
        meetbtn = (Button) viewGroup.findViewById(R.id.meetbtn);
        meetonetime = (CheckBox) viewGroup.findViewById(R.id.meetonetime);
        dbupdate = (Button) viewGroup.findViewById(R.id.update);

        meetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = meettitle.getText().toString();
                String description = meetdesc.getText().toString();
                String latitude = meetlat.getText().toString();
                String longitude = meetlon.getText().toString();

                if (title.equals("") || description.equals("") || latitude.equals("") || longitude.equals("")){
                    Toast.makeText(context,
                            "빈 칸이 있습니다.",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean insert = dbHelper.meetInsert(title, description, latitude, longitude, meetonetime.isChecked());
                    if (insert){
                        Toast.makeText(context,
                                "입력 성공",
                                Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(context,
                                "입력 오류 발생",
                                Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        dbupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                dbHelper.onUpgrade(db, 1, 2);
                db.close();
            }
        });
        return viewGroup;

    }
}
