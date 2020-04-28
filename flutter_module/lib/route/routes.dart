
import 'package:flutter/material.dart';
import 'package:fluttermodule/blog.dart';
import 'package:fluttermodule/home.dart';

/// 页面工厂
typedef PageFactory =  Widget Function();

class RouteItem{
  /// 路径
  final String path;
  /// 界面工厂
  final PageFactory pageFactory;

  RouteItem(this.path,this.pageFactory);
}

class Routes {
  static final RouteItem home = RouteItem("/home", () => HomePage());
  static final RouteItem blog = RouteItem("/blog", () => BlogPage());
}

/// 路由
Map<String,PageFactory> routes = {
  "home": ()=>HomePage(),
  "blog": ()=>BlogPage(),
};

