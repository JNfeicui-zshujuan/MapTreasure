package com.example.zheng.maptreasure.treasure;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhengshujuan on 2016/7/22.
 */
public class Area {
    @SerializedName("currentPage")
    private int currentPage = 1;

    @SerializedName("PagerSize")
    private int pagerSize = 50;

    @SerializedName("XlineMin")
    private double minLng;

    @SerializedName("XlineMax")
    private double maxLng;

    @SerializedName("YlineMin")
    private double minLat;

    public void setMaxLat(double maxLat) {
        this.maxLat = maxLat;
    }

    public void setMinLat(double minLat) {
        this.minLat = minLat;
    }

    public void setMaxLng(double maxLng) {
        this.maxLng = maxLng;
    }

    public void setMinLng(double minLng) {
        this.minLng = minLng;
    }

    public void setPagerSize(int pagerSize) {
        this.pagerSize = pagerSize;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @SerializedName("YlineMax")
    private double maxLat;
    @Override public int hashCode() {
        return (int)maxLat;
    }

    @Override public boolean equals(Object o) {
        if(!(o instanceof Area))return false;
        if(o == this)return true;
        Area other = (Area)o;
        return (int)maxLat == (int)other.maxLat && (int)maxLng == (int)other.maxLng;
    }

}
