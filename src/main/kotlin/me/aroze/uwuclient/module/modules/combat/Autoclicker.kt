package me.aroze.uwuclient.module.modules.combat

import me.aroze.uwuclient.command.command.Toggle.info
import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.events.EventUpdate
import me.aroze.uwuclient.module.Module
import me.aroze.uwuclient.module.ModuleInfo
import org.lwjgl.input.Mouse

@ModuleInfo(
    name = "Autoclicker",
    description = "Clicks for you whilst holding your attack button",
)
object Autoclicker : Module() {

    @EventInfo
    fun onUpdate(event: EventUpdate) {
        if (mc.gameSettings.keyBindAttack.isKeyDown) mc.clickMouse()
    }

}