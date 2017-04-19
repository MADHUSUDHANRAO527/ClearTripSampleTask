package com.example.goodworklabs.cleartriptask.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Madhu on 17/04/17.
 */

public class FeaturedActivityModel {


    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @SerializedName("editorial")
    private Editorial editorial;

    public ArrayList<CollectionsModel> getCollectionsModel() {
        return collectionsModel;
    }

    public void setCollectionsModel(ArrayList<CollectionsModel> collectionsModel) {
        this.collectionsModel = collectionsModel;
    }

    @SerializedName("collections")
    private ArrayList<CollectionsModel> collectionsModel;

    public ArrayList<Categories> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<Categories> category) {
        this.category = category;
    }

    @SerializedName("categories")
    private ArrayList<Categories> category;


}

