package com.example.webviewdemo;

import android.webkit.JavascriptInterface;

import luozf.utils.ToastU;

/**
 * js桥接类
 *
 * @author luozf
 * @date 2020/5/7
 */
public class JsBridge {

    /**
     * 桥接方法
     * 此处返回的方法，可以在js层直接通过返回值获得。
     * 如：
     * var ret = window.jsBridge.bridge(args)
     * 其中，ret即是 "java返回的参数"
     * @author luozf
     * @date 2020/5/7
     */
    @JavascriptInterface
    public String bridge(String arg){
        ToastU.show(arg);
        return "java返回的参数";
    }
}
