package com.example.goodworklabs.cleartriptask.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by GoodWorkLabs on 17/04/17.
 */

public class TTDModel {
    @SerializedName("cp")
    private ArrayList<Integer> cpModel;

    public ArrayList<Integer> getCpModel() {
        return cpModel;
    }

    public void setCpModel(ArrayList<Integer> cpModel) {
        this.cpModel = cpModel;
    }
}
