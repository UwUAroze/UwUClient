package me.aroze.uwuclient.module

import me.aroze.uwuclient.event.EventManager
import me.aroze.uwuclient.module.setting.Setting
import me.aroze.uwuclient.util.TimerMS
import net.minecraft.client.Minecraft

open class Module {

    val name: String
    val key: Int

    private val description: String
    private val category: ModuleCategory

    val settings: ArrayList<Setting> = ArrayList()

    var enabled = false
    protected var mc: Minecraft = Minecraft.getMinecraft()
    protected var timer: TimerMS = TimerMS()

    init {
        if (this::class.java.getAnnotation(ModuleInfo::class.java) == null) {
            throw RuntimeException("Module ${this::class.java.simpleName} is missing a ModuleInfo annotation!")
        }

        val moduleInfo = this::class.java.getAnnotation(ModuleInfo::class.java)
        name = moduleInfo.name
        description = moduleInfo.description
        category = moduleInfo.category
        key = moduleInfo.key
    }

    open fun onEnable() { /* omg */ }
    open fun onDisable() { /* omg */ }

    fun enabled(enabled: Boolean) {
        if (this.enabled == enabled) return
        this.enabled = enabled
        if (enabled) {
            EventManager.register(this)
            onEnable()
        } else {
            EventManager.unregister(this)
            onDisable()
        }
    }

    fun toggle() = enabled(!enabled)

}