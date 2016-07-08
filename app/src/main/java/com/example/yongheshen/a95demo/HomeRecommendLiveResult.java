package com.example.yongheshen.a95demo;

/**
 * Created by yonghe.shen on 16/7/7.
 */
public class HomeRecommendLiveResult {
    public int getLiveId() {
        return liveId;
    }

    public void setLiveId(int liveId) {
        this.liveId = liveId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getLastRate() {
        return lastRate;
    }

    public void setLastRate(double lastRate) {
        this.lastRate = lastRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLiveType() {
        return liveType;
    }

    public void setLiveType(String liveType) {
        this.liveType = liveType;
    }

    int liveId;
    String imgUrl;
    double lastRate;
    String name;
    String liveType;
}
