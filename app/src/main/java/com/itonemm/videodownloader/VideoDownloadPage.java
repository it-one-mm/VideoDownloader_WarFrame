package com.itonemm.videodownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class VideoDownloadPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_download_page);
        WebView webView=findViewById(R.id.download_view);
        Bundle bundle=getIntent().getExtras();
        String videolink=bundle.getString("download_link");
        webView.loadUrl(videolink);

        webView.getSettings().setJavaScriptEnabled(true);
    }
}
