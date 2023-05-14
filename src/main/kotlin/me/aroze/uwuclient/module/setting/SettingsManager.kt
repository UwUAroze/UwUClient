package me.aroze.uwuclient.module.setting

import me.aroze.uwuclient.module.ModuleManager
import java.lang.reflect.Field

object SettingsManager {

    fun registerSettings() {
        for (module in ModuleManager.modules) {
            val fields: Array<Field> = module.javaClass.declaredFields
            for (field in fields) {
                try {
                    if (field.type.superclass == Setting::class.java) {
                        field.isAccessible = true
                        val setting: Setting = field[module] as Setting
                        setting.module = module
                        module.settings.add(setting)
                    }
                } catch (_: Exception) { /* ignored */ }
            }
        }
    }

}