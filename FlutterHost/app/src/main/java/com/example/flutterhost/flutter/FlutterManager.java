package com.example.flutterhost.flutter;

import android.content.Context;
import android.content.Intent;

import com.example.flutterhost.MyApplication;
import com.example.flutterhost.MyFlutterActivity;

import io.flutter.app.FlutterActivity;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterView;
import luozf.utils.LogU;

//import io.flutter.app.FlutterActivity;
//import io.flutter.view.FlutterMain;

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

    private FlutterView flutterView;

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
        FlutterMain.Settings settings = new FlutterMain.Settings();
        settings.setLogTag("flutter_log");
        FlutterMain.startInitialization(MyApplication.getContext(),settings);

        Intent intent = new Intent(context, MyFlutterActivity.class);
        context.startActivity(intent);
    }

    public FlutterView createFlutterView(Context context){
        flutterView = new FlutterView(context);
        return flutterView;
    }

    public FlutterView getFlutterView(){
        return flutterView;
    }
}
