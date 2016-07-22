package com.example.zheng.maptreasure.map;

import com.example.zheng.maptreasure.Treasure;
import com.example.zheng.maptreasure.register.NetClient;
import com.example.zheng.maptreasure.treasure.Area;
import com.example.zheng.maptreasure.treasure.TreasureApi;
import com.example.zheng.maptreasure.treasure.TreasureRepo;
import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zhengshujuan on 2016/7/22.
 */
public class MapPresenter extends MvpNullObjectBasePresenter<MapMvpView> {
    private Call<List<Treasure>> call;
    private Area area;

    //核心业务,获取宝藏的指定区域
    public void getTreasure(Area area) {
        if (TreasureRepo.getInstance().isCached(area)) {
            return;
        }
        this.area = area;
        TreasureApi treasureApi = NetClient.getInstance().getTreasureApi();
        if (call != null) call.cancel();
        call = treasureApi.getTreasureInArea(area);
        call.enqueue(callback);
    }

    private final Callback<List<Treasure>> callback = new Callback<List<Treasure>>() {
        @Override
        public void onResponse(Call<List<Treasure>> call, Response<List<Treasure>> response) {
            if (response != null && response.isSuccessful()) {
                List<Treasure> datas = response.body();
                if (datas == null) {
                    getView().showMessage("unknow error");
                    return;
                }
                //缓存宝藏及区域
                TreasureRepo.getInstance().addTreasure(datas);
                TreasureRepo.getInstance().cache(area);
                //通知视图进行视图工作
                getView().setData(datas);
            }
        }

        @Override
        public void onFailure(Call<List<Treasure>> call, Throwable t) {
            getView().showMessage("failure" + t.getMessage());
            t.printStackTrace();
        }
    };

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (call != null) call.cancel();
    }
}
