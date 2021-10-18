package com.example.gesture_viewpager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class LogManager {
    // 로그를 관리하는 클래스입니다
    // 로그는 JSONArray 형태의 String 으로 저장합니다
    // 데이터 저장은 SharedPreferences 를 이용합니다

    private static TextView nameView;
    private static TextView ageView;
    private static TextView addressView;

    private static int currentIndex;
    private static int firstIndex;
    private static final int lastIndex = 0;

    private static JSONArray logArray;
    public static JSONObject currentJson;

    public static final String TEST_KEY = "testkey";
    public static final int MODE_DEFAULT = 0;
    public static final int MODE_NEXT = 1;
    public static final int MODE_PREV = 2;

    public static Context context;

    public static DialogInterface.OnClickListener send, cancel;



    public LogManager(){

    }

    public static void setContext (Context _context){
        context = _context;
    }


    public static void setTextView(TextView _nameView, TextView _ageView, TextView _addressView){
        nameView = _nameView;
        ageView = _ageView;
        addressView = _addressView;
    }

    public static void setLogArray(JSONArray jsonArray){
        logArray = jsonArray;
    }

    // Log 저장
    public static void setLog(Context context, String key, String value){
        // SharedPreferences 객체 생성
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // 데이터 저장
        editor.putString(key, value);
        editor.commit();
    }

    // Log 불러오기
    public static String getLog(Context context, String key){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String value = sharedPreferences.getString(key, null);

        return value;
    }

    public static void setJsonToView(int mode){
        // Log Data(Json)을 화면에 보이게 함
        firstIndex = logArray.length() - 1;



        // 기본 => currentIndex의 변화 없음
        if (mode == MODE_DEFAULT){
            // current Index = firstIndex 가 되게 한다 ( 화면 초기화 )
            currentIndex = firstIndex;
        } else if ( mode == MODE_NEXT){ // 다음 페이지 => currentIndex -1 을 해줌
            currentIndex -= 1;
            if (currentIndex <= 0 ) currentIndex = 0;

        } else if ( mode == MODE_PREV){ // 이전 페이지 => currentIndex +1 을 해줌
            currentIndex += 1;
            if (currentIndex >= firstIndex) currentIndex = firstIndex;
        }

        // 뷰를 보이게 함
        try{
            currentJson = logArray.getJSONObject(currentIndex);

            nameView.setText(currentJson.getString("name"));
            ageView.setText(currentJson.getInt("age")+"");
            addressView.setText(currentJson.getString("address"));

        } catch (Exception e){
            Log.d("LogFragment", e.getMessage());
        }

    }

    public static JSONObject setJsonObject(String name, int age, String address){
        JSONObject jObject = new JSONObject();

        try{
            jObject.put("name", name);
            jObject.put("age", age);
            jObject.put("address", address);
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }

        return jObject;
    }

    public static void addToJsonArray(JSONObject jObject){
        logArray.put(jObject);
    }


    public static void sendLog(){
        /*

        LongPress 시 sendLog() 실행
        sendLog() 에선 AlretDialog 실행
        AlertDialog에서 EditText로 상품명 입력받고 "전송"버튼 누름

        전송 버튼 누르면 서버로 전송 -> 이 부분은 DialogInterface.OnClickListener에 구현

         */
        send = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // 키보드 내리기
                InputMethodManager immhide = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                immhide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                // 서버 전송 부분

                // ----

            }
        };

        cancel = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // 키보드 내리기
                InputMethodManager immhide = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                immhide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);


                // 취소 작동 부분
                // ----
            }
        };

        View dialogView = (View) View.inflate(context, R.layout.log_dialog, null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("상품명 전송");
        dialog.setView(dialogView);
        dialog.setPositiveButton("전송", send);
        dialog.setNegativeButton("취소", cancel);
        dialog.show();

        // 키보드 올라오기
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);


    }
}
