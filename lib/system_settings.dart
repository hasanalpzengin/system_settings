import 'dart:async';

import 'package:flutter/services.dart';

class SystemSettings {
  static const MethodChannel _channel = const MethodChannel('system_settings');

  static Future<void> app({showInRecents=true}) async {
    return await _channel.invokeMethod('app', {"showInRecents": showInRecents});
  }

  static Future<void> appNotifications({showInRecents=true}) async {
    return await _channel.invokeMethod('app-notifications', {"showInRecents": showInRecents});
  }

  static Future<void> system({showInRecents=true}) async {
    return await _channel.invokeMethod('system', {"showInRecents": showInRecents});
  }

  static Future<void> location({showInRecents=true}) async {
    return await _channel.invokeMethod('location', {"showInRecents": showInRecents});
  }

  static Future<void> wifi({showInRecents=true}) async {
    return await _channel.invokeMethod('wifi', {"showInRecents": showInRecents});
  }

  static Future<void> bluetooth({showInRecents=true}) async {
    return await _channel.invokeMethod('bluetooth', {"showInRecents": showInRecents});
  }

  static Future<void> security({showInRecents=true}) async {
    return await _channel.invokeMethod('security', {"showInRecents": showInRecents});
  }

  static Future<void> display({showInRecents=true}) async {
    return await _channel.invokeMethod('display', {"showInRecents": showInRecents});
  }

  static Future<void> date({showInRecents=true}) async {
    return await _channel.invokeMethod('date', {"showInRecents": showInRecents});
  }

  static Future<void> sound({showInRecents=true}) async {
    return await _channel.invokeMethod('sound', {"showInRecents": showInRecents});
  }

  static Future<void> apps({showInRecents=true}) async {
    return await _channel.invokeMethod('apps', {"showInRecents": showInRecents});
  }

  static Future<void> wireless({showInRecents=true}) async {
    return await _channel.invokeMethod('wireless', {"showInRecents": showInRecents});
  }

  static Future<void> deviceInfo({showInRecents=true}) async {
    return await _channel.invokeMethod('device-info', {"showInRecents": showInRecents});
  }

  static Future<void> dataUsage({showInRecents=true}) async {
    return await _channel.invokeMethod('data-usage', {"showInRecents": showInRecents});
  }

  static Future<void> dataRoaming({showInRecents=true}) async {
    return await _channel.invokeMethod('data-roaming', {"showInRecents": showInRecents});
  }

  static Future<void> locale({showInRecents=true}) async {
    return await _channel.invokeMethod('locale', {"showInRecents": showInRecents});
  }

  static Future<void> defaultApps({showInRecents=true}) async {
    return await _channel.invokeMethod('default-apps', {"showInRecents": showInRecents});
  }

  static Future<void> airplaneMode({showInRecents=true}) async {
    return await _channel.invokeMethod('airplane-mode', {"showInRecents": showInRecents});
  }

  static Future<void> privacy({showInRecents=true}) async {
    return await _channel.invokeMethod('privacy', {"showInRecents": showInRecents});
  }

  static Future<void> accessibility({showInRecents=true}) async {
    return await _channel.invokeMethod('accessibility', {"showInRecents": showInRecents});
  }

  static Future<void> internalStorage({showInRecents=true}) async {
    return await _channel.invokeMethod('internal-storage', {"showInRecents": showInRecents});
  }

  static Future<void> nfc({showInRecents=true}) async {
    return await _channel.invokeMethod('nfc', {"showInRecents": showInRecents});
  }

  static Future<void> notificationPolicy({showInRecents=true}) async {
    return await _channel.invokeMethod('notification-policy', {"showInRecents": showInRecents});
  }
}
