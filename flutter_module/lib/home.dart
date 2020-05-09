

import 'package:flutter/material.dart';
import 'package:fluttermodule/route/RouteManager.dart';
import 'package:fluttermodule/route/route_cup.dart';
import 'package:fluttermodule/util/app_util.dart';
import 'package:fluttermodule/util/channel_util.dart';

/// 首页
class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
          alignment: Alignment.center,
          child: GestureDetector(
            onTap: (){
              if(AppUtil.settings.useNativeWeb){
                ChannelUtil.callNative(ChannelMethod.START_WEB);
              }
              RouteManager.push(context, RouteCup.BLOG);
            },
            child: Text("打开blog"),
          )),
    );
  }
}