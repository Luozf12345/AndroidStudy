package com.example.flutterhost.flutter;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.flutterhost.MainActivity;
import com.example.flutterhost.MyApplication;
import com.example.flutterhost.WebActivity;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterView;
import luozf.utils.ToastU;

public class ChannelUtil {


    private static final  String CHANNEL_NAME = "com.luozf.flutter/channel";

    static MethodChannel methodChannel = new MethodChannel(FlutterManager.getInstance().getFlutterView(),CHANNEL_NAME);

    public static void init(){
        methodChannel.setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
                switch (call.method){
                    case "START_WEB":
                        Intent intent = new Intent(MyApplication.getContext(), WebActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        MyApplication.getContext().startActivity(intent);
                        break;
                }
            }
        });
    }
}
