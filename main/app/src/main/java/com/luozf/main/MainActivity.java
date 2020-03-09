package com.luozf.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 主界面
 * 此项目旨在能将所有需要学习的动作整合在一起，并且每个知识点相对独立，可有独立运行的demo，提高运行速度
 * 因此考虑接入插件化技术，此为宿主工程，其他知识点将作为插件存在
 * @author luozf
 * @version V1.0.0
 * @date 2020/3/9
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
