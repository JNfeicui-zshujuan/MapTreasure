package com.example.zheng.maptreasure.account;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by zhengshujuan on 2016/7/15.
 */
public interface AccoutView extends MvpView {
    void showProgress();
    void hideProgress();
    void showMessage(String string );
    //更新头像
    void updataPhoto(String url);
}
