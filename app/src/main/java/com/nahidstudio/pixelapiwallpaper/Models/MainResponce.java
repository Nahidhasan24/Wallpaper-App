package com.nahidstudio.pixelapiwallpaper.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainResponce {

    @SerializedName("photos")
    private List<Responcce>  photo;

    public MainResponce(List<Responcce> photo) {
        this.photo = photo;
    }

    public List<Responcce> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Responcce> photo) {
        this.photo = photo;
    }
}
