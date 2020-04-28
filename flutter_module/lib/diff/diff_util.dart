export 'web/diff_route_util.dart' if(dart.library.io) "diff_route_util.dart";

/// 平台区分工具
/// 实现方法：web的引入在web目录，手机的引入在native目录，尽量最小化diff区分
class DiffUtil {

  /// web转换为了js语言，0和0.0的类型都是int；原生的分别是int和double，因此不相等。
  static bool get isWeb{
//    return 0.runtimeType == 0.0.runtimeType;
  // 检查两个引用是否是同一个对象
    return identical(0,0.0);
  }
}