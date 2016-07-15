package com.example.zheng.maptreasure.account;

import com.example.zheng.maptreasure.register.NetClient;
import com.example.zheng.maptreasure.register.UserApi;
import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import java.io.File;

import retrofit2.Call;


/**个人信息页面
 * Created by zhengshujuan on 2016/7/15.
 */
public class AccountPresenter extends MvpNullObjectBasePresenter<AccoutView> {
    private Call<UploadResult> uploadCall;
    private String photoUrl;
/**
 * 上传头像
 */
    public void uploadPhoto(File file){
        getView().showMessage();
        UserApi userApi= NetClient.getInstance().getUserApi();

    }

}
