package com.luozf.main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//import androidx.appcompat.app.AppCompatActivity;


import com.luozf.main.flutter.FlutterManager;
import com.luozf.main.plugin.PluginUtil;
import com.morgoo.droidplugin.PluginHelper;
import com.morgoo.droidplugin.pm.PluginManager;
import com.morgoo.helper.Log;

import java.security.Permissions;

import javax.security.auth.callback.Callback;

//import luozf.base.BaseActivity;
import luozf.utils.PermissionU;
import luozf.utils.ToastU;

/**
 * 主界面
 * 此项目旨在能将所有需要学习的动作整合在一起，并且每个知识点相对独立，可有独立运行的demo，提高运行速度
 * 因此考虑接入插件化技术，此为宿主工程，其他知识点将作为插件存在
 *
 * @author luozf
 * @version V1.0.0
 * @date 2020/3/9
 */
public class MainActivity extends BaseActivity {

    /**
     * 安装文本
     */
    private TextView installTv;
    /**
     * 启动Flutter
     */
    private TextView startFlutterTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//                        PluginUtil.installPlugin("TestPlugin-debug.apk");
        PluginUtil.installPlugin("app-debug.apk");
        installTv = findViewById(R.id.main_install_plugin);
        installTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionU.checkSavePermission(new PermissionU.PermissionCallBack() {
                    @Override
                    public void onSuccess() {
//                        PluginUtil.startPluginActivity("TestPlugin-debug.apk", "com.example.TestPlugin.MainActivity");
                        PluginUtil.startPluginActivity(MainActivity.this,"com.example.flutter_app", "com.example.flutter_app.MainActivity");
                    }

                    @Override
                    public void onDenied() {
                        ToastU.show("没有权限");
                    }
                });
            }
        });


        startFlutterTv = findViewById(R.id.main_start_flutter);
        startFlutterTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlutterManager.getInstance().startFlutterActivity(MainActivity.this);
            }
        });
    }

    @Override
    protected boolean needCheckSavePermission() {
//        TODO: BaseActivity需要修改
        return true;
    }
}
