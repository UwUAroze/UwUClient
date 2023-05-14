package me.aroze.uwuclient.util

import net.minecraft.client.Minecraft

object RotationUtil {

    fun getDirection(): Double {
        var rotationYaw = Minecraft.getMinecraft().thePlayer.rotationYaw

        if (Minecraft.getMinecraft().thePlayer.moveForward < 0F)
            rotationYaw += 180F

        var forward = 1F

        if (Minecraft.getMinecraft().thePlayer.moveForward < 0F) forward = -0.5F
        else if (Minecraft.getMinecraft().thePlayer.moveForward > 0F) forward = 0.5F

        if (Minecraft.getMinecraft().thePlayer.moveStrafing > 0F) rotationYaw -= 90F * forward
        if (Minecraft.getMinecraft().thePlayer.moveStrafing < 0F) rotationYaw += 90F * forward

        return Math.toRadians(rotationYaw.toDouble())
    }

}