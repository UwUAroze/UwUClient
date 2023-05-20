package me.aroze.uwuclient.module.modules.combat

import me.aroze.uwuclient.command.command.Toggle.info
import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.events.EventUpdate
import me.aroze.uwuclient.module.Module
import me.aroze.uwuclient.module.ModuleInfo
import me.aroze.uwuclient.module.setting.settings.NumberSetting
import net.minecraft.client.settings.KeyBinding
import org.lwjgl.input.Mouse

@ModuleInfo(
    name = "Autoclicker",
    description = "Clicks for you whilst holding your attack button",
)
object Autoclicker : Module() {

    val CPS = NumberSetting("CPS", 1, 20.0, 10.0)

    @EventInfo
    fun onUpdate(event: EventUpdate) {

        if (timer.hasReached(1000 / CPS.value.toLong()) && mc.gameSettings.keyBindAttack.isKeyDown) {
            KeyBinding.onTick(mc.gameSettings.keyBindAttack.keyCode)
            timer.reset()
        }

    }

}