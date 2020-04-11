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

import androidx.appcompat.app.AppCompatActivity;

import com.luozf.main.plugin.PluginUtil;
import com.morgoo.droidplugin.PluginHelper;
import com.morgoo.droidplugin.pm.PluginManager;
import com.morgoo.helper.Log;

import java.security.Permissions;

/**
 * 主界面
 * 此项目旨在能将所有需要学习的动作整合在一起，并且每个知识点相对独立，可有独立运行的demo，提高运行速度
 * 因此考虑接入插件化技术，此为宿主工程，其他知识点将作为插件存在
 * @author luozf
 * @version V1.0.0
 * @date 2020/3/9
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 安装文本
     */
    private TextView installTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        installTv = findViewById(R.id.main_install_plugin);
        installTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
                    PluginUtil.installPlugin("TestPlugin-debug.apk");

                    PackageInfo info = getPackageManager().getPackageArchiveInfo(PluginUtil.getPluginPath("TestPlugin-debug.apk"), PackageManager.GET_ACTIVITIES);
//                    PackageManager pm = getPackageManager();
//                    Intent intent = pm.getLaunchIntentForPackage(info.packageName);

//                    Intent intent = new Intent();
//                    intent.setClassName("com.example.TestPlugin","MainActivity");
                    PackageManager pm = getPackageManager();
                    Intent intent = pm.getLaunchIntentForPackage("com.example.TestPlugin");
                    if (intent != null) {
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    } else {
                        Log.e("Test","intent is null");
                    }
                }
            }
        });
    }
}
