package me.aroze.uwuclient.module.setting.settings

import me.aroze.uwuclient.module.setting.Setting

class NumberSetting(name: String, val min: Number, val max: Number, val value: Number) : Setting(name) {
}