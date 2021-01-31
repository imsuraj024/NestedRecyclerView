package com.suraj.nestedrecyclerview.models;

public class MyData {

    public static final int TYPE_ONE =0;
    public static final int TYPE_TWO =1;

    private String description;
    private int imgId;
    private int type;

    public MyData(int type, String description, int imgId) {
        this.type = type;
        this.description = description;
        this.imgId = imgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
