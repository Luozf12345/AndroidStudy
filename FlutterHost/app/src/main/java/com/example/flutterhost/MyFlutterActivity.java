package com.example.flutterhost;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.example.flutterhost.flutter.FlutterManager;

import io.flutter.app.FlutterActivityDelegate;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterRunArguments;
import io.flutter.view.FlutterView;
import luozf.base.BaseActivity;

/**
 * 自己实现的flutterActivity，使flutterView为单例
 */
public class MyFlutterActivity extends BaseActivity {

    FlutterView flutterView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 创建flutterView
         flutterView = FlutterManager.getInstance().createFlutterView(this);
         // 移除flutterView上次的parent
         if (flutterView.getParent() != null){
             ViewGroup parent = (ViewGroup)flutterView.getParent();
             parent.removeView(flutterView);
         }

         // 将flutterView添加进视图
        FrameLayout.LayoutParams matchParent = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        flutterView.setLayoutParams(matchParent);
        setContentView(flutterView);

    }

}
