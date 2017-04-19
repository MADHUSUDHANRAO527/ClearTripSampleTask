package com.example.goodworklabs.cleartriptask.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Madhu on 17/04/17.
 */

public class CollectionsModel {
    @SerializedName("vibrant_color")
    private String vibrantColor;

    @SerializedName("count_text")
    private String countText;

    @SerializedName("image")
    private String image;

    @SerializedName("collection_name")
    private String collectionName;

    public String getVibrantColor() {
        return vibrantColor;
    }

    public void setVibrantColor(String vibrantColor) {
        this.vibrantColor = vibrantColor;
    }

    public String getCountText() {
        return countText;
    }

    public void setCountText(String countText) {
        this.countText = countText;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public ArrayList<String> getCollectionsCategoriesIdsModel() {
        return collectionsCategoriesIdsModel;
    }

    public void setCollectionsCategoriesIdsModel(ArrayList<String> collectionsCategoriesIdsModel) {
        this.collectionsCategoriesIdsModel = collectionsCategoriesIdsModel;
    }

    @SerializedName("categories")
    private ArrayList<String> collectionsCategoriesIdsModel;

}
