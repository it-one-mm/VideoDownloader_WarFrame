package com.itonemm.videodownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    String FB_BASE_URL="https://fbdownload.org/download?video=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-9372372238168862~6660436996");
        AdLoader adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        ColorDrawable background=new ColorDrawable(Color.WHITE);
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().withMainBackgroundColor(background).build();

                        TemplateView template = findViewById(R.id.small_template);
                        template.setStyles(styles);
                        template.setNativeAd(unifiedNativeAd);

                    }
                })
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());
        AdLoader adLoader1 = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        ColorDrawable background=new ColorDrawable(Color.WHITE);
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().withMainBackgroundColor(background).build();

                        TemplateView template = findViewById(R.id.medium_template);
                        template.setStyles(styles);
                        template.setNativeAd(unifiedNativeAd);

                    }
                })
                .build();

        adLoader1.loadAd(new AdRequest.Builder().build());
    }

    public void buEnter(View view) throws UnsupportedEncodingException {

        EditText edt_link=findViewById(R.id.edt_link);
        String query=edt_link.getText().toString();
        String query_encode= URLEncoder.encode(query,"utf-8");
        String link=FB_BASE_URL+query_encode;
        Intent intent=new Intent(getApplicationContext(),VideoDownloadPage.class);
       intent.putExtra("download_link",link);
        startActivity(intent);

    }
}
