package com.example.realapp;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class SearchMap extends Fragment {

    private Context context;
    CheckBox onetimechk;
    EditText editTextFilter;
    ViewGroup viewGroup;
    TextView testText;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = container.getContext();
        viewGroup = (ViewGroup) inflater.inflate(R.layout.search_map, container, false);
//        final ArrayList<ListViewItem> filteredItemList = ListViewAdapter.getFilteredItemList();
//        testText = (TextView) viewGroup.findViewById(R.id.testtext);
//
//        editTextFilter.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                String filterText = editable.toString();
//                ((ListViewAdapter) SearchName.listView1.getAdapter()).getFilter().filter(filterText);
//                String str = "";
//                for(ListViewItem item : filteredItemList){
//                    str += item.getTitle() + "\t" + item.getLatStr() + "\t" + item.getLonStr() + "\n";
//                }
//                testText.setText(str);
//
//            }
//        });
//
//
        return viewGroup;
    }

    public void setOneTimeChk(CheckBox onetimechk){
        this.onetimechk = onetimechk;
    }

    public void setEditTextFilter(EditText editTextFilter){
        this.editTextFilter = editTextFilter;
    }
}
