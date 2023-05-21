package me.aroze.uwuclient.module.modules.combat

import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.events.EventUpdate
import me.aroze.uwuclient.module.Module
import me.aroze.uwuclient.module.ModuleInfo
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityLivingBase
import net.minecraft.network.play.client.C02PacketUseEntity
import net.minecraft.util.MathHelper
import org.lwjgl.input.Keyboard
import kotlin.math.atan2
import kotlin.math.sqrt


@ModuleInfo(
    name = "KillAura",
    description = "Automatically attacks entities around you",
    key = Keyboard.KEY_R,
)
object KillAura : Module() {

    @EventInfo
    fun onUpdate(event: EventUpdate) {
        val entity = getClosestEntity() ?: return
        if (entity !is EntityLivingBase) return
        if (timer.hasReached(1000 / 10)) {
            mc.thePlayer.swingItem()
            mc.thePlayer.sendQueue.addToSendQueue(C02PacketUseEntity(entity, C02PacketUseEntity.Action.ATTACK))
            timer.reset()
        }
        val rotations = getRotations() ?: return
        event.yaw = rotations.first
        event.pitch = rotations.second

        mc.thePlayer.rotationYawHead = rotations.first
        mc.thePlayer.renderYawOffset = rotations.first
        mc.thePlayer.rotationPitchHead = rotations.second
    }

    fun getRotations() : Pair<Float, Float>? {
        val entity = getClosestEntity() ?: return null
        val x = entity.posX - mc.thePlayer.posX
        val y = entity.posY - mc.thePlayer.posY
        val z = entity.posZ - mc.thePlayer.posZ
        val yaw = Math.toDegrees(atan2(z, x)) - 90.0
        val pitch = Math.toDegrees(atan2(y, sqrt(x * x + z * z)))
        return Pair(yaw.toFloat(), pitch.toFloat())
    }

//    fun getRotationsFixedSens(e: Entity?): FloatArray? {
//        val yaw: Float = getBypassRotate(e).get(0)
//        val pitch: Float = getBypassRotate(e).get(1)
//        val sens = 9f
//        var newYaw = MathHelper.wrapAngleTo180_float(deltaYaw - yaw)
//        var newPitch = MathHelper.wrapAngleTo180_float(deltaPitch - pitch)
//        if (newYaw > sens) newYaw = sens
//        if (newYaw < -sens) newYaw = -sens
//        if (newPitch > sens) newPitch = sens
//        if (newPitch < -sens) newPitch = -sens
//        if (deltaPitch > 90) deltaPitch = 90
//        deltaYaw -= newYaw
//        deltaPitch -= newPitch
//        hasRotated = Math.abs(newYaw) < 0.1 && Math.abs(newPitch) < 0.1
//        return floatArrayOf(deltaYaw + Random().nextInt(1), deltaPitch)
//    }

    fun getClosestEntity() : Entity? {
        var closestEntity: Entity? = null
        var closestEntityDistance = 3.0f
        for (entity in mc.theWorld.loadedEntityList) {
            val dist = mc.thePlayer.getDistanceToEntity(entity)
            if (entity != mc.thePlayer && entity.isEntityAlive && dist <= closestEntityDistance) {
                closestEntityDistance = dist
                closestEntity = entity
            }
        }
        return closestEntity
    }

}