package com.example.httptest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpConnection {


    private Handler handler;
    private String urlString;

    public HttpConnection(Handler handler, String urlString){
        this.handler = handler;
        this.urlString = urlString;
    }


    public void RequestGetMethod (){
        new Thread(new RequestConnection(1, urlString)).start();
    }

    class RequestConnection extends Thread {
        public int mode;
        public String urlStr;

        public RequestConnection(int _mode, String _urlStr) {
            this.mode = _mode;
            this.urlStr = _urlStr;

            // TEST CODE
            this.mode = 1;

        }

        public Message createMessage(String message){
            // 방법1
//            Message msg = Message.obtain(handler, 0, message);

            // 방법2
            Message msg = new Message();
            Bundle data = new Bundle();

            data.putString("result", message);
            msg.setData(data);

            return msg;

        }

        @Override
        public void run() {
            super.run();

            if (mode == 1){
                try{
                    URL url = new URL(urlStr);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    if (conn != null){
                        conn.setConnectTimeout(10000); // 10초동안 기다림 -> 응답이 없으면 종료
                        conn.setRequestMethod("GET");
                        conn.setDoInput(true);
                        conn.setDoOutput(true);

                        int resCode = conn.getResponseCode();
                        if(resCode == HttpURLConnection.HTTP_OK){
                            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                            StringBuilder sb = new StringBuilder();

                            String resultLine = null;

                            while(true){
                                resultLine = br.readLine();
                                if (resultLine == null){
                                    break;
                                } else {
                                    sb.append(resultLine);
                                }
                            }

                            Message msg = createMessage(sb.toString());
                            handler.sendMessage(msg);

                            br.close();
                            conn.disconnect();


                        }
                    }
                } catch (Exception e){
                    String result = e.getMessage();
                    Log.d("HTTP GET ERROR", result);

                    Message msg = createMessage(result);
                    handler.sendMessage(msg);
                } finally {

                }
            }
        }
    }


}
