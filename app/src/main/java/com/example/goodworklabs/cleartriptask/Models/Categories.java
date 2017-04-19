package com.example.goodworklabs.cleartriptask.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GoodWorkLabs on 17/04/17.
 */

public class Categories {
    @SerializedName("name")
    String name;

    @SerializedName("rank")
    String rank;

    @SerializedName("id")
    String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
