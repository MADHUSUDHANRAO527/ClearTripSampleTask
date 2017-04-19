package com.example.goodworklabs.cleartriptask.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GoodWorkLabs on 17/04/17.
 */

public class CarouselImages {
    @SerializedName("vibrant_color")
    private String vibrantColor;

    public String getVibrantColor() {
        return vibrantColor;
    }

    public void setVibrantColor(String vibrantColor) {
        this.vibrantColor = vibrantColor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @SerializedName("img")
    private String image;

    @SerializedName("order_no")
    private String orderNum;
}
