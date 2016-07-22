package com.example.zheng.maptreasure.treasure;

import com.example.zheng.maptreasure.Treasure;
import com.example.zheng.maptreasure.detail.TreasureDetail;
import com.example.zheng.maptreasure.detail.TreasureDetailResult;
import com.example.zheng.maptreasure.hide.HideTreasure;
import com.example.zheng.maptreasure.hide.HideTreasureResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

//.treasure.treasure.home.hide.HideTreasureResult;

//.detail.HideTreasure;
//        .treasure.treasure.home.detail.TreasureDetailResult;
//        .treasure.treasure.home.detail.TreasureDetail;

/**
 * 作者：yuanchao on 2016/7/19 0019 10:46
 * 邮箱：yuanchao@feicuiedu.com
 */
public interface TreasureApi {

    @POST("/Handler/TreasureHandler.ashx?action=show")
    Call<List<Treasure>> getTreasureInArea(@Body Area body);

    @POST("/Handler/TreasureHandler.ashx?action=hide")
    Call<HideTreasureResult> hideTreasure(@Body HideTreasure body);

    @POST("/Handler/TreasureHandler.ashx?action=tdetails")
    Call<List<TreasureDetailResult>> getTreasureDetail(@Body TreasureDetail body);
}