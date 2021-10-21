package com.example.retrofitpostdataresponse;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    /*@SerializedName("status")
    public String status;
    @SerializedName("result")
    public String result;
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public List<Data> data = null;


    public UserList(String status, String result, String message) {
        this.status = status;
        this.result = result;
        this.message = message;
    }

    public class Data {

        @SerializedName("CId")
        public Integer CId;
        @SerializedName("CatName")
        public String CatName;
        @SerializedName("Status")
        public String Status;
        @SerializedName("CreateDate")
        public String CreateDate;
    }*/

    @SerializedName("page")
    public Integer page;
    @SerializedName("per_page")
    public Integer perPage;
    @SerializedName("total")
    public Integer total;
    @SerializedName("total_pages")
    public Integer totalPages;
    @SerializedName("data")
    public List<Data> data = new ArrayList();

    public class Data {

        @SerializedName("id")
        public Integer id;
        @SerializedName("email")
        public String email;
        @SerializedName("first_name")
        public String first_name;
        @SerializedName("last_name")
        public String last_name;
        @SerializedName("avatar")
        public String avatar;

    }


}
