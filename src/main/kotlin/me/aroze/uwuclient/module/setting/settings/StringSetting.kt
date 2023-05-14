package me.aroze.uwuclient.module.setting.settings

import me.aroze.uwuclient.module.setting.Setting

class StringSetting(name: String, val values: Array<String>, var value: String) : Setting(name) {

    var index: Int

    init {
        index = values.indexOf(value)
    }

    fun cycle() {
        index++
        if (index >= values.size) index = 0
        value = values[index]
    }

    fun cycleReverse() {
        index--
        if (index < 0) index = values.size - 1
        value = values[index]
    }

    fun exists(value: String) = values.contains(value)

}