package me.aroze.uwuclient.module.modules.movement

import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.events.EventUpdate
import me.aroze.uwuclient.module.Module
import me.aroze.uwuclient.module.ModuleInfo

@ModuleInfo(
    name = "Sprint",
    description = "Automatically sprints",
)
object Sprint : Module() {

    @EventInfo
    fun onUpdate(event: EventUpdate) {

        // TODO: Add options for these
        if (mc.thePlayer.isCollidedHorizontally) return
        if (mc.thePlayer.moveForward <= 0) return
        if (mc.thePlayer.isSneaking) return

        mc.thePlayer.isSprinting = true
    }

}