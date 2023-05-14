package me.aroze.uwuclient.module.modules.movement

import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.events.EventUpdate
import me.aroze.uwuclient.module.Module
import me.aroze.uwuclient.module.ModuleInfo
import me.aroze.uwuclient.util.MoveUtil
import org.lwjgl.input.Keyboard

@ModuleInfo(
    name = "Speed",
    description = "Lets you go brrr",
    key = Keyboard.KEY_Z,
)
object Speed : Module() {

    @EventInfo
    fun onUpdate(event: EventUpdate) {

        if (!MoveUtil.isMoving()) return

        if (mc.thePlayer.onGround) {
            mc.thePlayer.jump()
            mc.thePlayer.motionY -= 0.15
            MoveUtil.strafe(0.48)
        }

        MoveUtil.strafe(0.25)

    }

}