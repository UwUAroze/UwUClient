package me.aroze.uwuclient.module.modules.combat

import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.events.EventUpdate
import me.aroze.uwuclient.module.Module
import me.aroze.uwuclient.module.ModuleInfo
import net.minecraft.entity.EntityLivingBase

@ModuleInfo(
    name = "AimAssist",
    description = "Automatically aims at entities around you",
)
object AimAssist : Module() {

    @EventInfo
    fun onUpdate(event: EventUpdate) {
        if (!mc.gameSettings.keyBindAttack.isKeyDown) return
        val entity = KillAura.getClosestEntity() ?: return
        if (entity !is EntityLivingBase) return

        val rotations = KillAura.getRotations() ?: return

        val yaw = mc.thePlayer.rotationYaw + ((rotations.first - mc.thePlayer.rotationYaw) / 10)
        val pitch = mc.thePlayer.rotationPitch + ((rotations.second - mc.thePlayer.rotationPitch) / 10)

        mc.thePlayer.rotationYaw = yaw
        mc.thePlayer.rotationPitch = pitch
    }

}