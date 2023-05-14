package me.aroze.uwuclient.module

import me.aroze.uwuclient.module.hud.Hud
import me.aroze.uwuclient.module.modules.movement.flight.VanillaFlight

object ModuleManager {

    val modules = ArrayList<Module>()

    fun registerModules() {
        register(VanillaFlight)
        register(Hud)
    }

    fun register(module: Module) = modules.add(module)

}