package com.example.realapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.List;


public class SearchName extends Fragment {
    private Context context;
    ViewGroup viewGroup;
    ListView listView1;
    CheckBox onetimechk;
    EditText editTextFilter;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    ListViewAdapter adapter;
    Cursor cursor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = container.getContext();
        viewGroup = (ViewGroup) inflater.inflate(R.layout.search_name, container, false);

//        // listView 참조 및 Adapter 담기
        listView1 = (ListView) viewGroup.findViewById(R.id.listview1);
//        adapter = new ListViewAdapter();
        // listView1.setAdapter를 여기서 해줘야함. SearchActivity에서 하면 에러
        listView1.setAdapter(adapter);
//        adapter.setChkbox(onetimechk);  // 체크박스 adapter에 넘겨주기


        String query = editTextFilter.getText().toString();




        // 텍스트 변경 이벤트 처리
        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String filterText = editable.toString();
                ((ListViewAdapter) listView1.getAdapter()).getFilter().filter(filterText);
            }
        });
        editTextFilter.setText(query);

        onetimechk.setOnClickListener(new View.OnClickListener() {  // 체크박스 변동 있을 시
            @Override
            public void onClick(View view) {
                String str = editTextFilter.getText().toString();
                ((ListViewAdapter) listView1.getAdapter()).getFilter().filter(str);
            }
        });

        // 아이템 클릭 이벤트 처리
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return viewGroup;
    }

    public void setOneTimeChk(CheckBox onetimechk){
        this.onetimechk = onetimechk;
    }

    public void setEditTextFilter(EditText editTextFilter){
        this.editTextFilter = editTextFilter;
    }

    public void setAdapter(ListViewAdapter adapter){
        this.adapter = adapter;
    }


    public ListView getListView(){
        return listView1;
    }
}
