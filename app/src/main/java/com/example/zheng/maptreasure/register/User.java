package com.example.zheng.maptreasure.register;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhengshujuan on 2016/7/14.
 */
public class User {
    @SerializedName("UserName")
    private String userName;

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    @SerializedName("Password")
    private String passWord;
    public User(String userName,String passWord){
        this.passWord=passWord;
        this.userName=userName;
    }
}
