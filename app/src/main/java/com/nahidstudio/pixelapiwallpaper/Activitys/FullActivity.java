package com.nahidstudio.pixelapiwallpaper.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.nahidstudio.pixelapiwallpaper.R;
import com.squareup.picasso.Picasso;

public class FullActivity extends AppCompatActivity {

    ImageView imageView;
    Button btn;
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);
        imageView=findViewById(R.id.iv);
        btn=findViewById(R.id.button);
        interstitialAd = new InterstitialAd(this, "490224982213238_490226025546467");
        String url=getIntent().getStringExtra("Image");
        Picasso.get().load(url).into(imageView);
        getSupportActionBar().hide();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    WallpaperManager wallpaperManager =WallpaperManager.getInstance(getApplicationContext());
                    Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();

                        if (bitmap!=null){
                            wallpaperManager.setBitmap(bitmap);
                            Toast.makeText(FullActivity.this, "Wallpaper Set Successfully!", Toast.LENGTH_SHORT).show();
                        }


                }catch (Exception e){
                    Toast.makeText(FullActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        showads();
    }

    private void showads() {
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
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

        super.onBackPressed();
    }
}