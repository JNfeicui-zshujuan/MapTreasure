package com.example.zheng.maptreasure.account;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhengshujuan on 2016/7/15.
 */
public class UploadResult {
    @SerializedName("errcode")
    private String msg;

    public String getMsg() {
        return msg;
    }

    public int  getCount() {
        return Count;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @SerializedName("urlcount")
    private int  Count;
    @SerializedName("smallImgUrl")
    private String imageUrl;
}
