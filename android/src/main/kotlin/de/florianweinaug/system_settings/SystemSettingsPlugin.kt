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
    var newTask: Boolean = call.argument<Boolean>("androidNewTask")!!
    when (call.method) {
      "app"                 -> openAppSettings(newTask)
      "app-notifications"   -> openAppNotificationSettings(newTask)
      "system"              -> openSystemSettings(newTask)
      "location"            -> openSetting(Settings.ACTION_LOCATION_SOURCE_SETTINGS, newTask)
      "wifi"                -> openSetting(Settings.ACTION_WIFI_SETTINGS, newTask)
      "bluetooth"           -> openSetting(Settings.ACTION_BLUETOOTH_SETTINGS, newTask)
      "security"            -> openSetting(Settings.ACTION_SECURITY_SETTINGS, newTask)
      "display"             -> openSetting(Settings.ACTION_DISPLAY_SETTINGS, newTask)
      "date"                -> openSetting(Settings.ACTION_DATE_SETTINGS, newTask)
      "sound"               -> openSetting(Settings.ACTION_SOUND_SETTINGS, newTask)
      "apps"                -> openSetting(Settings.ACTION_APPLICATION_SETTINGS, newTask)
      "wireless"            -> openSetting(Settings.ACTION_WIRELESS_SETTINGS, newTask)
      "device-info"         -> openSetting(Settings.ACTION_DEVICE_INFO_SETTINGS, newTask)
      "data-usage"          -> openSetting(Settings.ACTION_DATA_USAGE_SETTINGS, newTask)
      "data-roaming"        -> openSetting(Settings.ACTION_DATA_ROAMING_SETTINGS, newTask)
      "locale"              -> openSetting(Settings.ACTION_LOCALE_SETTINGS, newTask)
      "default-apps"        -> openSetting(Settings.ACTION_MANAGE_DEFAULT_APPS_SETTINGS, newTask)
      "airplane-mode"       -> openSetting(Settings.ACTION_AIRPLANE_MODE_SETTINGS, newTask)
      "privacy"             -> openSetting(Settings.ACTION_PRIVACY_SETTINGS, newTask)
      "accessibility"       -> openSetting(Settings.ACTION_ACCESSIBILITY_SETTINGS, newTask)
      "internal-storage"    -> openSetting(Settings.ACTION_INTERNAL_STORAGE_SETTINGS, newTask)
      "notification-policy" -> openSetting(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS, newTask)
      "nfc"                 -> openSetting(Settings.ACTION_NFC_SETTINGS, newTask)
      else                  -> result.notImplemented()
    }
  }

  private fun openAppSettings(newTask: Boolean) {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)

    val uri = Uri.fromParts("package", registrar.context().packageName, null)
    intent.data = uri
    if(newTask){ intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
    registrar.context().startActivity(intent)
  }

  private fun openAppNotificationSettings(newTask: Boolean) {
    val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
              .putExtra(Settings.EXTRA_APP_PACKAGE, registrar.context().packageName)
    } else {
      Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
              .setData(Uri.parse("package:${registrar.context().packageName}"))
    }
    if(newTask){ intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
    registrar.context().startActivity(intent)
  }

  private fun openSetting(name: String, newTask: Boolean) {
    try {
      var intent: Intent = Intent(name);
      if(newTask){ intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
      registrar.context().startActivity(intent)
    } catch (e: Exception) {
      openSystemSettings(newTask)
    }
  }

  private fun openSystemSettings(newTask: Boolean) {
    var intent: Intent = Intent(Settings.ACTION_SETTINGS);
    if(newTask){ intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
    registrar.context().startActivity(intent)
  }
}
