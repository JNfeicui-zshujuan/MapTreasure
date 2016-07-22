package com.example.zheng.maptreasure.map;

import com.example.zheng.maptreasure.Treasure;
import com.hannesdorfmann.mosby.mvp.MvpFragment;

import java.util.List;

/**
 * Created by zhengshujuan on 2016/7/22.
 */
public class MapFragment extends MvpFragment<MapMvpView,MapPresenter> implements MapMvpView{
    @Override
    public MapPresenter createPresenter() {
        return null;
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setData(List<Treasure> data) {

    }
}
