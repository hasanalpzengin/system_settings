package de.florianweinaug.system_settings

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.NonNull;
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar
import java.lang.Exception

public class SystemSettingsPlugin(private val registrar: Registrar): MethodCallHandler {
  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "system_settings")
      channel.setMethodCallHandler(SystemSettingsPlugin(registrar))
    }
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    var showInRecents: Boolean = call.argument<Boolean>("showInRecents")!!
    when (call.method) {
      "app"                 -> openAppSettings(showInRecents)
      "app-notifications"   -> openAppNotificationSettings(showInRecents)
      "system"              -> openSystemSettings(showInRecents)
      "location"            -> openSetting(Settings.ACTION_LOCATION_SOURCE_SETTINGS, showInRecents)
      "wifi"                -> openSetting(Settings.ACTION_WIFI_SETTINGS, showInRecents)
      "bluetooth"           -> openSetting(Settings.ACTION_BLUETOOTH_SETTINGS, showInRecents)
      "security"            -> openSetting(Settings.ACTION_SECURITY_SETTINGS, showInRecents)
      "display"             -> openSetting(Settings.ACTION_DISPLAY_SETTINGS, showInRecents)
      "date"                -> openSetting(Settings.ACTION_DATE_SETTINGS, showInRecents)
      "sound"               -> openSetting(Settings.ACTION_SOUND_SETTINGS, showInRecents)
      "apps"                -> openSetting(Settings.ACTION_APPLICATION_SETTINGS, showInRecents)
      "wireless"            -> openSetting(Settings.ACTION_WIRELESS_SETTINGS, showInRecents)
      "device-info"         -> openSetting(Settings.ACTION_DEVICE_INFO_SETTINGS, showInRecents)
      "data-usage"          -> openSetting(Settings.ACTION_DATA_USAGE_SETTINGS, showInRecents)
      "data-roaming"        -> openSetting(Settings.ACTION_DATA_ROAMING_SETTINGS, showInRecents)
      "locale"              -> openSetting(Settings.ACTION_LOCALE_SETTINGS, showInRecents)
      "default-apps"        -> openSetting(Settings.ACTION_MANAGE_DEFAULT_APPS_SETTINGS, showInRecents)
      "airplane-mode"       -> openSetting(Settings.ACTION_AIRPLANE_MODE_SETTINGS, showInRecents)
      "privacy"             -> openSetting(Settings.ACTION_PRIVACY_SETTINGS, showInRecents)
      "accessibility"       -> openSetting(Settings.ACTION_ACCESSIBILITY_SETTINGS, showInRecents)
      "internal-storage"    -> openSetting(Settings.ACTION_INTERNAL_STORAGE_SETTINGS, showInRecents)
      "notification-policy" -> openSetting(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS, showInRecents)
      "nfc"                 -> openSetting(Settings.ACTION_NFC_SETTINGS, showInRecents)
      else                  -> result.notImplemented()
    }
  }

  private fun openAppSettings(showInRecents: Boolean) {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)

    val uri = Uri.fromParts("package", registrar.context().packageName, null)
    intent.data = uri
    if(!showInRecents){ intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS); }
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    registrar.context().startActivity(intent)
  }

  private fun openAppNotificationSettings(showInRecents: Boolean) {
    val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
              .putExtra(Settings.EXTRA_APP_PACKAGE, registrar.context().packageName)
    } else {
      Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
              .setData(Uri.parse("package:${registrar.context().packageName}"))
    }
    if(!showInRecents){ intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS); }
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    registrar.context().startActivity(intent)
  }

  private fun openSetting(name: String, showInRecents: Boolean) {
    try {
      var intent: Intent = Intent(name);
      if(!showInRecents){ intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS); }
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      registrar.context().startActivity(intent)
    } catch (e: Exception) {
      openSystemSettings(showInRecents)
    }
  }

  private fun openSystemSettings(showInRecents: Boolean) {
    var intent: Intent = Intent(Settings.ACTION_SETTINGS);
    if(!showInRecents){ intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS); }
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    registrar.context().startActivity(intent)
  }
}
