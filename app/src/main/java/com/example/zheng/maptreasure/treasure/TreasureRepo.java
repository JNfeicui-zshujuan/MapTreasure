package com.example.zheng.maptreasure.treasure;

import com.example.zheng.maptreasure.Treasure;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhengshujuan on 2016/7/22.
 * 宝藏仓库,用来强引用宝藏及区域数据
 */
public class TreasureRepo {
    private static TreasureRepo treasureRepo;

    public static TreasureRepo getInstance() {
        if (treasureRepo == null) {
            treasureRepo = new TreasureRepo();
        }
        return treasureRepo;
    }

    private TreasureRepo() {

    }

    //用来保存已经获取到的区域
    private final HashSet<Area> cachesArea = new HashSet<>();
    //用来保存全部的获取到的区域
    private final HashMap<Integer, Treasure> treasureMap = new HashMap<>();

    public void cache(Area area) {
        cachesArea.add(area);
    }

     //是否已经获取过
    public boolean isCached(Area area) {
    //先比hashCode,再比squals
        return cachesArea.contains(area);
    }

    public void addTreasure(List<Treasure> treasureList) {
        for (Treasure treasure : treasureList) {
            treasureMap.put(treasure.getId(), treasure);
        }
    }

    public Treasure getTreasure(int id) {
        return treasureMap.get(id);
    }

    public Collection<Treasure> getTreasure() {
        return treasureMap.values();
    }

    public void clear() {
        treasureMap.clear();
        cachesArea.clear();
    }
}
