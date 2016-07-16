package com.example.zheng.maptreasure.account;

import com.example.zheng.maptreasure.register.NetClient;
import com.example.zheng.maptreasure.register.UserApi;
import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * 个人信息页面
 * Created by zhengshujuan on 2016/7/15.
 */
public class AccountPresenter extends MvpNullObjectBasePresenter<AccoutView> {
    private Call<UploadResult> uploadCall;
    private String photoUrl;

    /**
     * 上传头像
     */
    public void uploadPhoto(File file) {
        getView().showMessage("上传头像");
        UserApi userApi = NetClient.getInstance().getUserApi();
        //构建部分
        RequestBody body = RequestBody.create(null, file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("image", "photo.png", body);
//上传头像
        if (uploadCall == null) uploadCall.cancel();
        uploadCall = userApi.upload(part);
        uploadCall.enqueue(upLoadCallBack);
    }

    public Callback<UploadResult> upLoadCallBack = new Callback<UploadResult>() {
        @Override
        public void onResponse(Call<UploadResult> call, Response<UploadResult> response) {
            if (response != null && response.isSuccessful()) {//响应成功
                UploadResult result = response.body();//获得响应体的数据
                if (result == null) {
                    getView().showMessage("unkown error");
                    return;
                }
                getView().showMessage(result.getMsg());
                if (result.getCount() != 1) {//上传不成功
                    return;
                }
                photoUrl = result.getImageUrl();//获取上传后的照片地址
                getView().updataPhoto(photoUrl);
                String puotoName=photoUrl.substring(photoUrl.lastIndexOf("/")+1,photoUrl.length());
                //过去token
int token=UserPrefs.getInstance().getTokenId();
            }

        }

        @Override
        public void onFailure(Call<UploadResult> call, Throwable t) {
            getView().hideProgress();
            getView().showMessage("头像获取失败");
        }
    };

}
