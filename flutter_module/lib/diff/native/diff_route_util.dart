import 'dart:ui';

import '../../util/string_util.dart';

class DiffRouteUtil {

  /// 初始化路由
  static String initialRoue() {
    return getRouteName(window.defaultRouteName);
  }

  /// 获取真正的路由名称
  static String getRouteName(String string){
    String path = string;
    if(StringUtil.isEmpty(path)){
      return "";
    }
    // 切割url,以/#/之后，？之前的字符串作为初始路径
    String result = path..split("?")[0];
    print("realRouteName: $result");
    return result;
  }
}