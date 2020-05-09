
/// App的设置类
class Settings {

  /// 构造函数私有化
  Settings._();

  /// 单例
  static Settings _instance;

  /// 获取单例
  factory Settings.getInstance() {
    if(_instance == null) {
      _instance = Settings._();
    }
    return _instance;
  }

  /// true：打开原生界面WebView，false：使用webview_flutter;只在混合模式下有效。
  bool useNativeWeb = true;
}

typedef OnSettingsChange = void Function();