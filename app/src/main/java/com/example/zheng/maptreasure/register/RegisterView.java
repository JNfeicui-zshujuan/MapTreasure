package com.example.zheng.maptreasure.register;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by zhengshujuan on 2016/7/13.
 */
public interface RegisterView extends MvpView {
    //显示进度条
    void showProgress();
    //隐藏进度条
    void hideProgress();
    //登录home 界面
    void EnterHomeActivty();
    //显示信息
    void showMessage(String msg);
}
