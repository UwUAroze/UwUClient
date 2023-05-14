package me.aroze.uwuclient.util

import me.aroze.uwuclient.util.RotationUtil.getDirection
import net.minecraft.client.Minecraft
import net.minecraft.util.MathHelper

object MoveUtil {

    fun isMoving(): Boolean {
        val player = Minecraft.getMinecraft().thePlayer
        return player != null && (player.moveForward != 0.0F || player.moveStrafing != 0.0F)
    }

    fun strafe(speed: Double) {
        if (!isMoving())
            return

        val yaw = getDirection()
        Minecraft.getMinecraft().thePlayer.motionX = -MathHelper.sin(yaw.toFloat()) * speed
        Minecraft.getMinecraft().thePlayer.motionZ = MathHelper.cos(yaw.toFloat()) * speed
    }

}