package com.example.webviewdemo;

import android.os.Bundle;

import androidx.annotation.Nullable;

import luozf.base.BaseActivity;

public class SubActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }
}
