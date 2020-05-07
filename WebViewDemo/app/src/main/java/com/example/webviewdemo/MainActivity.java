package com.example.webviewdemo;

import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import luozf.UtilsComm;


/**
 * WebView测试Demo。主要用户测试js桥接，以及WebView相关知识点
 * js桥接实现步骤：
 * 1.添加webView控件,设置允许JavaScriptEnable
 * 2.实现JsBridge类，标注@JavascriptInterface方法
 * 3.将JsBridge添加进WebView
 * 4.加载html。如果有本地服务器则可以部署。否则可以直接通过file:///android_asset/加载assets目录
 * 5.添加网络权限、添加明文网址（如果需要）
 *
 * WebView调试：
 * 参考：https://blog.csdn.net/freak_csh/article/details/95585148
 * 1.调用WebView.setWebContentsDebuggingEnabled(true)，允许调试。
 * 2.chrome访问chrome://inspect
 * 3.打开手机usb调试，链接上手机，选择想要的页面，即可调试
 * @author luozf
 * @date 2020/5/7
 */public class MainActivity extends AppCompatActivity {

    /**
     * js桥接名称
     */
    private static final String JS_BRIDGE_NAME = "jsBridge";

     WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UtilsComm.init(getApplicationContext());

        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.main_webview);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new JsBridge(),JS_BRIDGE_NAME);

//        webView.loadUrl("http://10.114.5.94:8888/public/jsBridge.html");
        webView.loadUrl("file:///android_asset/jsBridge.html");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }
}
