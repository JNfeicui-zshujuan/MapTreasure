package com.example.zheng.maptreasure.register;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhengshujuan on 2016/7/14.
 * 注册的响应结果的实体类
 *
 */
public final class registerResult  {
    @SerializedName("tokenid")
    private int tokenId;

    @SerializedName("errcode")
    private int code;

    @SerializedName("errmsg")
    private String msg;

    public int getTokenId() {
        return tokenId;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
