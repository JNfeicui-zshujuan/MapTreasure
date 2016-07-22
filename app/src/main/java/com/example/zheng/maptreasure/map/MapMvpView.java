package com.example.zheng.maptreasure.map;

import com.example.zheng.maptreasure.Treasure;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

/**
 * Created by zhengshujuan on 2016/7/22.
 */
public interface MapMvpView extends MvpView {
    void showMessage(String msg);
    void setData(List<Treasure> data);
}
