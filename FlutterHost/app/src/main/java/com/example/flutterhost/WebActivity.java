package com.example.flutterhost;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;

import luozf.base.BaseActivity;

public class WebActivity extends BaseActivity {


    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = findViewById(R.id.web);
        webView.loadUrl("https://blog.csdn.net/luozaifei1997");
    }
}
