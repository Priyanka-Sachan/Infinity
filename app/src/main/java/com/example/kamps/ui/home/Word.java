package com.example.kamps.ui.home;

public class Word {
    private String mNewsTitle;
    private String mNewsDescription;
    private int mImageResourceId;

    public  Word(){
    }


    public Word(String newstitle, String newsdesc,int imageResourceId) {
        mNewsTitle= newstitle;
        mNewsDescription = newsdesc;
        mImageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String gettitle() {
        return mNewsTitle;
    }


    public String getdesc() {
        return mNewsDescription;
    }

    public String getmNewsTitle() {
        return mNewsTitle;
    }

    public String getmNewsDescription() {
        return mNewsDescription;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
}
