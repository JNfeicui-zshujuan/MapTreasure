package com.example.zheng.maptreasure.account;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.zheng.maptreasure.R;
import com.example.zheng.maptreasure.commons.ActivityUtils;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

public class AccountActivity extends MvpActivity<AccoutView,AccountPresenter> implements AccoutView {
private ActivityUtils utils;
    private IconSelectWindow selectWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

    }

    @NonNull
    @Override
    public AccountPresenter createPresenter() {
        return new AccountPresenter();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage() {

    }

    @Override
    public void updataPhoto() {

    }
}
