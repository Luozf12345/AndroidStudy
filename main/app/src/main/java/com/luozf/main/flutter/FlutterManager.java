package com.luozf.main.flutter;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.luozf.main.MainActivity;
import com.luozf.main.MyApplication;

//import io.flutter.app.FlutterActivity;
//import io.flutter.view.FlutterMain;
import luozf.utils.LogU;

/**
 * Flutter管理工具
 * Flutter混合开发接入方法：https://flutter.dev/docs/development/add-to-app/android/project-setup
 * 步骤：
 * 1.在setting引入：
 *      setBinding(new Binding([gradle: this]))
 *      evaluate(new File(
 *        settingsDir.parentFile,
 *        'my_flutter/.android/include_flutter.groovy'
 *      ))
 * 2.在build.gradle依赖：
 *      implementation project(path:':flutter')
 *
 * 遇到问题：
 * 1.启动失败：FlutterActivity未在Manifest注册，需要注册才能启动
 * 2.ensureInitializationComplete must be called after startInitialization：在启动FlutterActivity之前，调用FlutterMain.startInitialization()初始化引擎
 * @author luozf
 * @date 2020/4/26
 */
public class FlutterManager {

    private static FlutterManager instance;

    public static FlutterManager getInstance(){
        if (instance == null){
            synchronized (FlutterManager.class){
                if (instance == null){
                    instance = new FlutterManager();
                }
            }
        }
        return instance;
    }

    public void startFlutterActivity(Context context){
        if (context == null){
            LogU.e("context is null");
            return;
        }
        // 启动Activity之前，必须先初始化，否则会报错
//        FlutterMain.Settings settings = new FlutterMain.Settings();
//        settings.setLogTag("flutter_log");
//        FlutterMain.startInitialization(MyApplication.getContext(),settings);
//
//        Intent intent = new Intent(context, FlutterActivity.class);
//        context.startActivity(intent);
    }
}
