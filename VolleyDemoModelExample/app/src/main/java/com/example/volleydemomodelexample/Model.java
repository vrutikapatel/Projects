package com.example.volleydemomodelexample;

public class Model {

    private String name, realname ,imageurl;

    public Model() {
    }

    public Model(String name, String realname, String imageurl) {
        this.name = name;
        this.realname = realname;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
