package me.aroze.uwuclient.module.modules.movement.flight

import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.events.EventUpdate
import me.aroze.uwuclient.module.Module
import me.aroze.uwuclient.module.ModuleInfo
import me.aroze.uwuclient.util.MoveUtil
import me.aroze.uwuclient.util.MoveUtil.isMoving
import me.aroze.uwuclient.util.MoveUtil.strafe
import org.lwjgl.input.Keyboard

@ModuleInfo(
    name = "Fly",
    description = "Allows you to fly in vanilla minecraft",
    key = Keyboard.KEY_F,
)
object VanillaFlight : Module() {

    @EventInfo
    fun onUpdate(event: EventUpdate) {
        if (mc.gameSettings.keyBindJump.isKeyDown) mc.thePlayer.motionY += 3
        else if (mc.gameSettings.keyBindSneak.isKeyDown) mc.thePlayer.motionY -= 3
        else mc.thePlayer.motionY = 0.0
        strafe(3.0)
        if (isMoving()) {
            mc.thePlayer.cameraPitch = 0.1f
            mc.thePlayer.cameraYaw = 0.1f
        }
    }

}