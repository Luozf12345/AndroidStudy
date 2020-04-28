

import 'package:flutter/material.dart';
import 'package:fluttermodule/route/RouteManager.dart';

import 'diff/diff_util.dart';

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
              RouteManager.push(context, "/blog");
            },
            child: Text("打开blog \n isWeb： ${DiffUtil.isWeb}"),
          )),
    );
  }
}