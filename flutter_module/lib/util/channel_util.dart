import 'package:flutter/services.dart';

/// 渠道方法工具
class ChannelUtil {

  static const _CHANNEL_NAME = "com.luozf.flutter/channel";

  static MethodChannel _channel = new MethodChannel(_CHANNEL_NAME);

  /// 初始化渠道方法
  static init(){
//    _channel.setMethodCallHandler((call) {
//
//    });
  }

  /// 调用原生方法
  static dynamic callNative(String method, {dynamic args}){
    try {
      return _channel.invokeListMethod(method,args);
    } catch (e) {
      print(e);
    }
    return null;
  }
}

class ChannelMethod {
  static const String START_WEB = "START_WEB";
}