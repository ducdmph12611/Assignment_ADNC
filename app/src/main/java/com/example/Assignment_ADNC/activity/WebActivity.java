package com.example.Assignment_ADNC.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Assignment_ADNC.R;

public class WebActivity extends AppCompatActivity {
    WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
         webView1= findViewById(R.id.webView);
        Intent intent = getIntent();
        String url = intent.getStringExtra("link");
        webView1.loadUrl(url);
    }
}
