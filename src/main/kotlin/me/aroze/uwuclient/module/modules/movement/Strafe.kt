package me.aroze.uwuclient.module.modules.movement

import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.events.EventUpdate
import me.aroze.uwuclient.module.Module
import me.aroze.uwuclient.module.ModuleInfo
import me.aroze.uwuclient.util.MoveUtil

@ModuleInfo(
    name = "Strafe",
    description = "Allows you to strafe further than vanilla",
)
object Strafe : Module() {

    @EventInfo
    fun onUpdate(event: EventUpdate) {
        MoveUtil.strafe(0.48)
    }

}