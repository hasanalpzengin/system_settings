import 'dart:async';

import 'package:flutter/services.dart';

class SystemSettings {
  static const MethodChannel _channel = const MethodChannel('system_settings');

  static Future<void> app({androidNewTask=true}) async {
    return await _channel.invokeMethod('app', {"androidNewTask": androidNewTask});
  }

  static Future<void> appNotifications({androidNewTask=true}) async {
    return await _channel.invokeMethod('app-notifications', {"androidNewTask": androidNewTask});
  }

  static Future<void> system({androidNewTask=true}) async {
    return await _channel.invokeMethod('system', {"androidNewTask": androidNewTask});
  }

  static Future<void> location({androidNewTask=true}) async {
    return await _channel.invokeMethod('location', {"androidNewTask": androidNewTask});
  }

  static Future<void> wifi({androidNewTask=true}) async {
    return await _channel.invokeMethod('wifi', {"androidNewTask": androidNewTask});
  }

  static Future<void> bluetooth({androidNewTask=true}) async {
    return await _channel.invokeMethod('bluetooth', {"androidNewTask": androidNewTask});
  }

  static Future<void> security({androidNewTask=true}) async {
    return await _channel.invokeMethod('security', {"androidNewTask": androidNewTask});
  }

  static Future<void> display({androidNewTask=true}) async {
    return await _channel.invokeMethod('display', {"androidNewTask": androidNewTask});
  }

  static Future<void> date({androidNewTask=true}) async {
    return await _channel.invokeMethod('date', {"androidNewTask": androidNewTask});
  }

  static Future<void> sound({androidNewTask=true}) async {
    return await _channel.invokeMethod('sound', {"androidNewTask": androidNewTask});
  }

  static Future<void> apps({androidNewTask=true}) async {
    return await _channel.invokeMethod('apps', {"androidNewTask": androidNewTask});
  }

  static Future<void> wireless({androidNewTask=true}) async {
    return await _channel.invokeMethod('wireless', {"androidNewTask": androidNewTask});
  }

  static Future<void> deviceInfo({androidNewTask=true}) async {
    return await _channel.invokeMethod('device-info', {"androidNewTask": androidNewTask});
  }

  static Future<void> dataUsage({androidNewTask=true}) async {
    return await _channel.invokeMethod('data-usage', {"androidNewTask": androidNewTask});
  }

  static Future<void> dataRoaming({androidNewTask=true}) async {
    return await _channel.invokeMethod('data-roaming', {"androidNewTask": androidNewTask});
  }

  static Future<void> locale({androidNewTask=true}) async {
    return await _channel.invokeMethod('locale', {"androidNewTask": androidNewTask});
  }

  static Future<void> defaultApps({androidNewTask=true}) async {
    return await _channel.invokeMethod('default-apps', {"androidNewTask": androidNewTask});
  }

  static Future<void> airplaneMode({androidNewTask=true}) async {
    return await _channel.invokeMethod('airplane-mode', {"androidNewTask": androidNewTask});
  }

  static Future<void> privacy({androidNewTask=true}) async {
    return await _channel.invokeMethod('privacy', {"androidNewTask": androidNewTask});
  }

  static Future<void> accessibility({androidNewTask=true}) async {
    return await _channel.invokeMethod('accessibility', {"androidNewTask": androidNewTask});
  }

  static Future<void> internalStorage({androidNewTask=true}) async {
    return await _channel.invokeMethod('internal-storage', {"androidNewTask": androidNewTask});
  }

  static Future<void> nfc({androidNewTask=true}) async {
    return await _channel.invokeMethod('nfc', {"androidNewTask": androidNewTask});
  }

  static Future<void> notificationPolicy({androidNewTask=true}) async {
    return await _channel.invokeMethod('notification-policy', {"androidNewTask": androidNewTask});
  }
}
