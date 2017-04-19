package com.example.goodworklabs.cleartriptask.Events;


import com.example.goodworklabs.cleartriptask.Models.FeaturedActivityModel;

/**
 * Created by GoodWorkLabs on 17-04-2017.
 */

public class AcitivityEvent {
    public final boolean success;
    public int errorCode;
    public String error;

    public FeaturedActivityModel model;
    public static final int JSON_ERROR = -3;

    public AcitivityEvent(boolean success, int errorCode, FeaturedActivityModel featuredActivityModel) {
        this.success = success;
        this.errorCode = errorCode;
        this.model = featuredActivityModel;
    }

    public AcitivityEvent(boolean success, String error) {
        this.success = success;
        this.error = error;
    }
}
