package bwei.com.yankuo20180619;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import bwei.com.yankuo20180619.model.MainBean;

public class Utils {
    private static Utils utils=new Utils();
    private MyHandler myHandler=new MyHandler();
    public static Utils getIntence(){
        if (utils==null){
            Utils utils = new Utils();
        }
        return utils;
    }
    public void get(final String url){
        new Thread(){
            @Override
            public void run() {
                try {
                    URL u = new URL(url);
                    HttpURLConnection connection= (HttpURLConnection) u.openConnection();
                    connection.setConnectTimeout(3000);
                    if (connection.getResponseCode()==200){
                        InputStream json = connection.getInputStream();
                        Message message = myHandler.obtainMessage();
                        message.what=0;
                        message.obj=json;
                        myHandler.sendMessage(message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }.start();
    }
    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    String json= (String) msg.obj;
                    Gson gson = new Gson();
                    MainBean mainBean = gson.fromJson(json, MainBean.class);
                    String msg1 = mainBean.getMsg();
                    break;
            }
        }
    }
    httpcontent httpcontent;
    public interface httpcontent{
        void getuscss(String msg);
        void geterror(String error);
    }
    public void gethttpcontent(httpcontent httpcontent){
        this.httpcontent=httpcontent;
    }
}
