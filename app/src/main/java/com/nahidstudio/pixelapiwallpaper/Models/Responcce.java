package com.nahidstudio.pixelapiwallpaper.Models;

import com.google.gson.annotations.SerializedName;

public class Responcce {

    @SerializedName("src")
    private PhotoDaimention src;

    public PhotoDaimention getSrc() {
        return src;
    }

    public void setSrc(PhotoDaimention src) {
        this.src = src;
    }
}
