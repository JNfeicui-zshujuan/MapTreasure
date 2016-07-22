package com.example.zheng.maptreasure;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by zhengshujuan on 2016/7/22.
 */
public class Treasure implements Serializable {
@SerializedName("tdid")
private int id;
    @SerializedName("tdtname")
    private String title;
    /**
     * 纬度
     */
    @SerializedName("htyline")
    private double latitude;
    /**
     * 经度
     */
    @SerializedName("htxline")
    private double longitude;

    @SerializedName("htheight")
    private double altitude;

    @SerializedName("htpoi")
    private String location;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public String getLocation() {
        return location;
    }

    public int getLevel() {
        return level;
    }

    public int getSize() {
        return size;
    }

    /**
     * 寻找难度
     */
    @SerializedName("htlevels")
    private int level;

    /**
     * 宝物大小
     */
    @SerializedName("htsize")
    private int size;


}
