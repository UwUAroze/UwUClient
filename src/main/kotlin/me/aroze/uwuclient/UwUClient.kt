package me.aroze.uwuclient

import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.EventManager
import me.aroze.uwuclient.event.events.EventKey
import me.aroze.uwuclient.module.ModuleManager
import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText
import org.lwjgl.input.Keyboard

class UwUClient {

    fun start() {
        println("Starting UwUClient")
        ModuleManager.registerModules()
        EventManager.register(this)
    }

    @EventInfo
    fun onKey(event: EventKey) {
        for (module in ModuleManager.modules) {
            if (module.key == event.key) module.toggle()
        }
    }

    fun printToChat(message: String) {
        Minecraft.getMinecraft().ingameGUI.chatGUI.printChatMessage(ChatComponentText(message))
    }

}