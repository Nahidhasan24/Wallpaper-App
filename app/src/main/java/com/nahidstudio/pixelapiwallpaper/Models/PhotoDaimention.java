package com.nahidstudio.pixelapiwallpaper.Models;

import com.google.gson.annotations.SerializedName;

public class PhotoDaimention {

    @SerializedName("medium")
    private String medium;

    @SerializedName("original")
    private String original;

    @SerializedName("large")
    private String large;

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
