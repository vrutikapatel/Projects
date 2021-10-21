package com.example.retrofitpostdataresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
    @SerializedName("CId")
    @Expose
    private String cId;
    @SerializedName("CatName")
    @Expose
    private String catName;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("CreateDate")
    @Expose
    private String createDate;

    public Datum() {
    }

    public Datum(String catName, String status, String createDate) {
        this.catName = catName;
        this.status = status;
        this.createDate = createDate;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
