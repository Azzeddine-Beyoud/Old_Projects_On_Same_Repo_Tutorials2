package com.example.firebaseuploadexample;

public class Upload {
    private String mName,mImageUrl;


    public Upload() {

    }

    public Upload(String name, String imageUrl) {
        if (name.trim().equals("")){
            name = "No name";
        }

        this.mName = name;
        this.mImageUrl = imageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
