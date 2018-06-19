package bwei.com.yankuo20180619.model;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MianModel {
    public void login(final String account,String password,final getcadeModelCallback getcadeModelCallback){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        FormBody formBody = new FormBody.Builder()
                .add("mobile", account)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .post(formBody)
                .url("https://www.zhaoapi.cn/user/reg")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                MainBean mainBean = gson.fromJson(json, MainBean.class);
                String msg = mainBean.getMsg();
                getcadeModelCallback.getuscss(msg);
            }
        });
    }
    public interface getcadeModelCallback{
        void getuscss(String msg);
        void geterror(String error);
    }
}
