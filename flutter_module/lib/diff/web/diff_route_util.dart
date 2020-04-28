import 'dart:html';

import '../../util/string_util.dart';

class DiffRouteUtil {


  /// 初始化路由
  static String initialRoue() {
    return getRouteName(window.location.href);
  }

  /// 获取真正的路由名称
  static String getRouteName(String string){
    String url = string;
    String protocol = window.location.protocol;
    String host = window.location.host;
    String path = url.replaceFirst(protocol+"//", "").replaceFirst(host, "");
    if(StringUtil.isEmpty(path)){
      return "";
    }
    if(path.startsWith("/#")){
      path = path.replaceFirst("/#", "");
    }
    if(StringUtil.isEmpty(path)){
      return "";
    }
    // 切割url,以/#/之后，？之前的字符串作为初始路径
    String result = path.split("?")[0];
    print("realRouteName: $result");
    return result;
  }
}