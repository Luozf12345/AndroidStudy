import 'web/diff_route_util.dart' if(dart.library.io) "native/diff_route_util.dart";
export 'web/diff_route_util.dart' if(dart.library.io) "native/diff_route_util.dart";

/// web和native的差异处理
abstract class Diff {

  static DiffRouteUtil get diffRouteUtil =>DiffRouteUtilImpl();
}


/// 路由差异工具
abstract class DiffRouteUtil {

  /// 初始化路由
  String initialRoute();

  /// 获取真正的路由名称
  String getRouteName(String string);
}