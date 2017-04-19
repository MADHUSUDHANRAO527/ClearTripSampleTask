package com.example.goodworklabs.cleartriptask.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Madhu on 17/04/17.
 */

public class CarouselModel {
    @SerializedName("seq_no")
    private int seqNo;

    @SerializedName("title")
    private String title;

    @SerializedName("tag_text")
    private String tagTxt;

    public String getTagTxt() {
        return tagTxt;
    }

    public void setTagTxt(String tagTxt) {
        this.tagTxt = tagTxt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @SerializedName("sub_title")
    private String subTitle;

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public ArrayList<CarouselImages> getCarouselImages() {
        return carouselImages;
    }

    public void setCarouselImages(ArrayList<CarouselImages> carouselImages) {
        this.carouselImages = carouselImages;
    }

    @SerializedName("images")
    private ArrayList<CarouselImages> carouselImages;

    @SerializedName("id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
