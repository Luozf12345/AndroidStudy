
import 'package:flutter/material.dart';
import 'package:fluttermodule/platform/interface.dart';
import 'package:fluttermodule/route/route_cup.dart';
import 'package:fluttermodule/util/string_util.dart';

import '../home.dart';

/// 路由管理器
class RouteManager {

  static String _initialRoue = "";

  /// 如果是网页打开，在此获取url地址，并跳转相应路径
  static void initHref() {
    _initialRoue = Diff.diffRouteUtil.initialRoute();
  }


  /// 初始化路径
  static get initialRoute => _initialRoue;

  /// 找不到路径的默认页面
  static Widget _defaultPage = HomePage();

  /// 生成路由，在此处理页面跳转
  static RouteFactory onGenerateRoute(){
    return (setting){
      return PageRouteBuilder(settings: setting,pageBuilder: (context,animation1,animation2){
        String name = Diff.diffRouteUtil.getRouteName(setting.name);
        if(StringUtil.isEmpty(name) || name == "/"){
          return _defaultPage;
        }
        PageFactory pageFactory =  RouteCup.routeMap[name];
        if(pageFactory != null){
          return pageFactory();
        }
        return _defaultPage;
      });
    };
  }

  /// 页面跳转
  static void push(BuildContext context, String route) {
    Navigator.pushNamed(context, route);
  }


}