package com.example.plugin_library;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * 插件界面
 * @Author:luozf
 * @Date: 2020/4/13
 */
public class PluginProxyActivity extends AppCompatActivity {

    /**
     * 插件路径
     */
    private String apkPath;

    /**
     * 插件Activity的名字
     */
    private String activityName;

    /**
     * 插件真正的Activity
     */
    private IPluginActivity realActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getBundleExtra("bundle");
        if (bundle != null){
            apkPath = bundle.getString(PluginConst.APK_PATH);
            activityName = bundle.getString(PluginConst.REALLY_ACTIVITY_NAME);
        }

        initRealActivity(bundle);
    }

    /**
     * 初始化真正的Activity.
     * 1.通过反射创建对象
     * 2.将代理类和真正类绑定
     * 3.真正Activity的onCreate什么周期
     *
     * @author luozf
     * @date 2020/4/17
     */
    private void initRealActivity(Bundle bundle) {
        PluginItem item = PluginManager.getInstance().getPluginItem(apkPath);
        if (item != null && item.getDexClassLoader() != null) {
            try {
                Class<?> clazz = item.getDexClassLoader().loadClass(activityName);
                realActivity = (IPluginActivity) clazz.newInstance();
                realActivity.attach(this);
                bundle.putBoolean(PluginConst.isPlugin, true);
                realActivity.onCreate(bundle);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ClassLoader getClassLoader() {
        PluginItem item = PluginManager.getInstance().getPluginItem(apkPath);
        if (item != null && item.getDexClassLoader() != null) {
            return item.getDexClassLoader();
        }
        return super.getClassLoader();
    }

    @Override
    public Resources getResources() {
        PluginItem item = PluginManager.getInstance().getPluginItem(apkPath);
        if (item != null && item.getResources() != null) {
            return item.getResources();
        }
        return super.getResources();
    }

    @Override
    protected void onStart() {
        if (realActivity != null) {
            realActivity.onStart();
        }
        super.onStart();
    }

    @Override
    protected void onRestart() {
        if (realActivity != null) {
            realActivity.onRestart();
        }
        super.onRestart();
    }

    @Override
    protected void onResume() {
        if (realActivity != null) {
            realActivity.onResume();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        if (realActivity != null) {
            realActivity.onPause();
        }
        super.onPause();
    }

    @Override
    protected void onStop() {
        if (realActivity != null) {
            realActivity.onStop();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (realActivity != null) {
            realActivity.onDestroy();
        }
        super.onDestroy();
    }
}
