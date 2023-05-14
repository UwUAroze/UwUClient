package me.aroze.uwuclient.module

import me.aroze.uwuclient.module.hud.Hud
import me.aroze.uwuclient.module.modules.misc.UwUChat
import me.aroze.uwuclient.module.modules.movement.Sprint
import me.aroze.uwuclient.module.modules.movement.flight.VanillaFlight
import me.aroze.uwuclient.module.modules.player.NoFall

object ModuleManager {

    val modules = ArrayList<Module>()

    fun registerModules() {
        register(
            VanillaFlight, Hud, UwUChat, NoFall, Sprint
        )
    }

    fun register(vararg module: Module) = modules.addAll(module)

    fun getModule(name: String): Module? {
        for (module in modules) {
            if (module.name.replace(" ", "").equals(name, true)) return module
        }
        return null
    }

}