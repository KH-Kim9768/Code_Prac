package com.example.gesture_viewpager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// 생성자에서 save, set Log 할 시 NullPointException 발생 --> onCreateView에서 실행 시 오류 발생 x

public class LogFragment extends Fragment{
    View rootView;
    ViewGroup container;

    TextView actionView;
    TextView dataView;

    TextView nameView;
    TextView ageView;
    TextView addressView;

    JSONArray logArray;

    String dummyJson = "[{'name':'배트맨','age':43,'address':'고담'},"+
            "{'name':'슈퍼맨','age':36,'address':'뉴욕'},"+
            "{'name':'앤트맨','age':25,'address':'LA'}, " +
            "{'name':'김광희','age':25,'address':'Seoul'}]";

    int currentIndex;
    int firstIndex;
    int lastIndex = 0;

    public LogFragment(){

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.container = container;

        rootView = inflater.inflate(R.layout.log_fragment_layout, container, false);

        actionView = rootView.findViewById(R.id.action_view);
        dataView = rootView.findViewById(R.id.data_view);

        nameView = rootView.findViewById(R.id.name_text);
        ageView = rootView.findViewById(R.id.age_text);
        addressView = rootView.findViewById(R.id.address_text);

        LogManager.setTextView(nameView, ageView, addressView);

        MainActivity.customGestureListener.setTextView(actionView);

//        testJson();

        // 초기 셋팅
        try{
            Log.d("LogFragment", "DO : Save DummyJson Array");

            logArray = new JSONArray(dummyJson);

            Log.d("LogFragment", "DO : Success DummyJson to Array");

            saveJSONArray();

            Log.d("LogFragment", "DO : Save Finished : DummyJson Array");

        } catch (Exception e){
            Log.d("LogFragment", "ERROR : Save Json Err on Constructor");
            e.printStackTrace();
        }

        // JSONArray 불러오기
        setJSONArray();

        // Log 화면에 셋팅
        LogManager.setJsonToView(LogManager.MODE_DEFAULT);


        // JSON 추가 테스트
        JSONObject testJson = LogManager.setJsonObject("김철수", 43, "한국");
        JSONObject testJson2 = LogManager.setJsonObject("영희", 33, "경기도");

        LogManager.addToJsonArray(testJson);
        LogManager.addToJsonArray(testJson2);

        saveJSONArray();
        // JSON 추가 테스트

        LogManager.setContext(getActivity());

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        actionView.setText("PAUSE");
    }

    @Override
    public void onResume() {
        super.onResume();
        
        // JSONArray 불러오기
        setJSONArray();
        actionView.setText("RESUME");


//        setJsonToView();
    }

    private void testJson(){

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(dummyJson);
            String dummyView = "";

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jObject = jsonArray.getJSONObject(i);
                dummyView += jObject.getString("name");
                dummyView += jObject.getInt("age");
                dummyView += jObject.getString("address");
            }

            JSONObject dummyJsonObj = new JSONObject();
            dummyJsonObj.put("name", "김광희");
            dummyJsonObj.put("age", 25);
            dummyJsonObj.put("address", "seoul");

            jsonArray.put(dummyJsonObj);

            dataView.setText(dummyView + "\n" + jsonArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    private void setJSONArray(){
        String logString = LogManager.getLog(getActivity(), LogManager.TEST_KEY);
        try{

            logArray = new JSONArray(logString);
            LogManager.setLogArray(logArray);

        } catch (Exception e){

            dataView.setText(e.getMessage());

        }

    }

    private void saveJSONArray(){
        Log.d("LogFragment", "Do : saveJSONArray");
        String jsonArrayString = logArray.toString();
        Log.d("LogFragment", "Do : Success logArray.toString()");
        LogManager.setLog(getActivity(), LogManager.TEST_KEY, jsonArrayString);

    }

    public void setJsonToView(){
        firstIndex = logArray.length() - 1;

        try{
            JSONObject jObject = logArray.getJSONObject(firstIndex);

            nameView.setText(jObject.getString("name"));
            ageView.setText(jObject.getInt("age")+"");
            addressView.setText(jObject.getString("address"));

        } catch (Exception e){
            Log.d("LogFragment", e.getMessage());
        }

    }



    // TEST
    public void setLog(String key, String value){
        // SharedPreferences 객체 생성
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("LogPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // 데이터 저장
        editor.putString(key, value);
        editor.commit();
    }

    public String getLog(String key){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("LogPreferences", Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(key, null);

        return value;
    } // TEST
}


