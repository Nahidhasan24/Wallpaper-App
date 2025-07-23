package com.nahidstudio.pixelapiwallpaper.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.nahidstudio.pixelapiwallpaper.Adapters.MainAdapter;
import com.nahidstudio.pixelapiwallpaper.Networking.Api;
import com.nahidstudio.pixelapiwallpaper.Models.MainResponce;
import com.nahidstudio.pixelapiwallpaper.Models.Responcce;
import com.nahidstudio.pixelapiwallpaper.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String BASEURL="https://api.pexels.com/v1/";
    String apikey="your_api_key";
    int page=1;
    ProgressBar  progressBar;
    NestedScrollView nestedScrollView;
    List<Responcce> photoDaimentions = new ArrayList<>();
    Api api;
    MainAdapter mainAdapter ;
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        interstitialAd = new InterstitialAd(this, "490224982213238_490226025546467");
        recyclerView=findViewById(R.id.Recyclerview);
         progressBar = (ProgressBar)findViewById(R.id.progress);
        Sprite doubleBounce = new WanderingCubes();
        progressBar.setIndeterminateDrawable(doubleBounce);

        nestedScrollView=findViewById(R.id.nestedSchrollView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api=retrofit.create(Api.class);
        fatch(page);

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (scrollY==v.getChildAt(0).getMeasuredHeight()-v.getMeasuredHeight()){
                    fatch(++page);
                }
            }
        });

    }
    private void fatch(int page) {
        Call<MainResponce> call = api.getData(apikey, this.page, 80);
        call.enqueue(new Callback<MainResponce>() {
            @Override
            public void onResponse(Call<MainResponce> call, Response<MainResponce> response) {
                MainResponce mainResponce = response.body();
                photoDaimentions.addAll(mainResponce.getPhoto());
                mainAdapter = new MainAdapter(getApplicationContext(), photoDaimentions);
                recyclerView.setAdapter(mainAdapter);
                progressBar.setVisibility(View.INVISIBLE);
                showads();
            }

            @Override
            public void onFailure(Call<MainResponce> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
       private void showads(){
            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onError(Ad ad, AdError adError) {

                }

                @Override
                public void onAdLoaded(Ad ad) {
                    interstitialAd.show();
                }

                @Override
                public void onAdClicked(Ad ad) {
                    //Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    //Toast.makeText(MainActivity.this, "Impression", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    //Toast.makeText(MainActivity.this, "Ads Show", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
                    //Toast.makeText(MainActivity.this, "Ads Dismiss", Toast.LENGTH_SHORT).show();
                }
            };

            interstitialAd.loadAd(
                    interstitialAd.buildLoadAdConfig()
                            .withAdListener(interstitialAdListener)
                            .build());

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.about){
            Toast.makeText(this, "Developed By NahidSoftware", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
