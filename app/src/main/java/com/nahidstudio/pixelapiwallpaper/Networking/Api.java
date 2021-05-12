package com.nahidstudio.pixelapiwallpaper.Networking;

import com.nahidstudio.pixelapiwallpaper.Models.MainResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface Api {

    @GET("curated")
    Call<MainResponce> getData(
      @Header("Authorization") String ApiKey,
      @Query("page") int pageCount,
      @Query("per_page") int perPage
    );
}
