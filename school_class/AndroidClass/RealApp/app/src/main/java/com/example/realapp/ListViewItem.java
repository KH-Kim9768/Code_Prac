package com.example.realapp;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable;
    private String titleStr;
    private String descStr;
    private String latStr;
    private String lonStr;
    private String onetimeStr;

    public void setIcon(Drawable icon){
        iconDrawable = icon;

    }

    public void setTitle(String title){
        titleStr = title;

    }

    public void setDesc(String desc){
        descStr = desc;
    }

    public void setLatStr(String lat){
        latStr = lat;
    }

    public void setLonStr(String lon){
        lonStr = lon;
    }

    public void setOnetime(String onetime){
        onetimeStr = onetime;
    }


    public Drawable getIcon(){
        return this.iconDrawable;
    }

    public String getTitle(){
        return this.titleStr;
    }

    public String getDesc(){
        return this.descStr;
    }

    public String getLatStr(){
        return this.latStr;
    }

    public String getLonStr(){
        return this.lonStr;
    }

    public String getOnetimeStr(){
        return this.onetimeStr;
    }
}
