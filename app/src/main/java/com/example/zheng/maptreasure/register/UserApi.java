package com.example.zheng.maptreasure.register;

import com.example.zheng.maptreasure.account.UploadResult;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**将用户模块API，转为Java接口
 * Created by zhengshujuan on 2016/7/15.
 */
public interface UserApi {
    @POST("/Handler/UserHandler.ashx?action=register")
    Call<registerResult> register(@Body User user);

//    @POST("/Handler/UserHandler.ashx?action=login")
//    Call<LoginResult> login(@Body User user);

    // 头像上传(是一个多部分请求)
    @Multipart
    @POST("/Handler/UserLoadPicHandler1.ashx")
    Call<UploadResult> upload(@Part MultipartBody.Part part);

}
