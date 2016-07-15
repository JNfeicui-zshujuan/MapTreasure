package com.example.zheng.maptreasure.register;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by zhengshujuan on 2016/7/13.
 */
public class RegisterPresenter extends MvpNullObjectBasePresenter<RegisterView> {
    private Gson gson;
    private Call call;
    private Handler handler = new Handler(Looper.getMainLooper());


    public RegisterPresenter() {
        gson = new Gson();
    }

    //核心业务操作
    public void register(User result) {
        OkHttpClient client = NetClient.getInstance().getHttpClient();

        RequestBody body = RequestBody.create(null, gson.toJson(result));
        Request request = new Request.Builder()
                .url("http://admin.syfeicuiedu.com/Handler/UserHandler.ashx?action=register")
                .post(body)
                .build();
        call = client.newCall(request);
        call.enqueue(callBack);

    }

    private Callback callBack = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                String jsonStr = response.body().string();
                registerResult result = gson.fromJson(jsonStr, registerResult.class);
                if (result.getCode() == 1) {
                    success(result.getMsg());
                    return;
                }
                failure(result.getMsg());
                return;
            }
            failure("不知道");
        }
    };

    private void failure(final String msg) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                getView().hideProgress();
                getView().showMessage(msg);
            }
        });
    }

    private void success(final String msg) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                getView().hideProgress();
                getView().showMessage(msg);
                getView().EnterHomeActivty();
            }
        });
    }
}
