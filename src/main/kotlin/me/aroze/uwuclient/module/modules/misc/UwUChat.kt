package me.aroze.uwuclient.module.modules.misc

import me.aroze.arozeutils.minecraft.generic.uwuify
import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.events.EventPacketChat
import me.aroze.uwuclient.module.Module
import me.aroze.uwuclient.module.ModuleInfo
import net.minecraft.util.ChatComponentText
import org.lwjgl.input.Keyboard

@ModuleInfo(
    name = "UwU Chat",
    description = "UwUifies chat messages",
    key = Keyboard.KEY_U,
)
object UwUChat : Module() {

    @EventInfo
    fun onChat(event: EventPacketChat) {
        event.chatComponent = ChatComponentText(uwuify(event.chatComponent.unformattedText))
    }

}