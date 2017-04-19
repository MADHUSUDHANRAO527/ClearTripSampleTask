package com.example.goodworklabs.cleartriptask.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by GoodWorkLabs on 17/04/17.
 */

public class Editorial {
    public ArrayList<CarouselModel> getCarouselModels() {
        return carouselModels;
    }

    public void setCarouselModels(ArrayList<CarouselModel> carouselModels) {
        this.carouselModels = carouselModels;
    }

    @SerializedName("carousel")
    private ArrayList<CarouselModel> carouselModels;
    @SerializedName("ttd")
    private TTDModel ttdModel;

    public TTDModel getTtdModel() {
        return ttdModel;
    }

    public void setTtdModel(TTDModel ttdModel) {
        this.ttdModel = ttdModel;
    }
}
