package me.aroze.uwuclient.module.modules.player

import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.events.EventUpdate
import me.aroze.uwuclient.module.ModuleCategory
import me.aroze.uwuclient.module.ModuleInfo
import me.aroze.uwuclient.module.Module

@ModuleInfo(
    name = "NoFall",
    description = "Prevents fall damage",
    category = ModuleCategory.PLAYER
)
object NoFall : Module() {

    @EventInfo
    fun onUpdate(event: EventUpdate) {
        event.onGround = true
    }

}