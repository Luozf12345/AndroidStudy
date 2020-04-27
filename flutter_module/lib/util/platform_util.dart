
/// 平台区分工具
class PlatformUtil {

  /// web转换为了js语言，0和0.0的类型都是int；原生的分别是int和double，因此不相等。
  static bool get isWeb{
    return 0.runtimeType == 0.0.runtimeType;
  }
}