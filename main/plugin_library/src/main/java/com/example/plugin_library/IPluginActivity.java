package com.example.plugin_library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 代理Activity接口。Acitivity的有些方法是私有或者保护的，插件Activity实现该接口，可以让代理Activity调用
 *
 * @author luozf
 * @date 2020/4/17
 */
public interface IPluginActivity {

    /**
     * 将插件Activity和代理Activity绑定
     * @param activity
     */
    void attach(Activity activity);

    // 以下全都是Activity生命周期函数,
    // 插件Activity本身 在被用作"插件"的时候不具备生命周期，由宿主里面的代理Activity类代为管理
    void onCreate(Bundle saveInstanceState);

    void onStart();

    void onResume();

    void onRestart();

    void onPause();

    void onStop();

    void onDestroy();

    void onActivityResult(int requestCode, int resultCode, Intent data);
}
