
import 'package:flutter/material.dart';
import 'package:fluttermodule/blog.dart';
import 'package:fluttermodule/home.dart';

/// 页面工厂
typedef PageFactory =  Widget Function();

/// 路由路径容器，其中，常量包含flutter路径和原生路径，map只包含flutter路径映射
class RouteCup {
  /// 首页
  static const String HOME = "/home";
  /// 博客
  static const String BLOG = "/blog";
  /// 原生页面
  static const String NATIVE = "/native";

  /// 路由
  static final Map<String, PageFactory> routeMap = {
    HOME: () => HomePage(),
    BLOG: () => BlogPage(),
  };

}

