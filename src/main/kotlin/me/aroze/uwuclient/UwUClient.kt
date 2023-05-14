package me.aroze.uwuclient

import me.aroze.arozeutils.minecraft.generic.coloured
import me.aroze.uwuclient.command.CommandManager
import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.EventManager
import me.aroze.uwuclient.event.events.EventKey
import me.aroze.uwuclient.module.ModuleManager
import me.aroze.uwuclient.module.modules.misc.UwUChat
import me.aroze.uwuclient.module.setting.SettingsManager
import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText
import org.lwjgl.input.Keyboard

class UwUClient {

    companion object {
        lateinit var instance: UwUClient
    }

    // todo: add tits

    fun start() {
        instance = this
        println("Starting UwUClient")
        EventManager.register(this)
        ModuleManager.registerModules()
        SettingsManager.registerSettings()
        CommandManager.registerCommands()
    }

    @EventInfo
    fun onKey(event: EventKey) {
        for (module in ModuleManager.modules) {
            if (module.key == event.key) module.toggle()
        }
    }

    fun printToChat(message: String) {
        Minecraft.getMinecraft().ingameGUI.chatGUI.printChatMessage(ChatComponentText(message.replace("&", "§")))
    }

    fun printWithPrefix(message: String, prefix: String = "&dUwUClient") = printToChat("$prefix &8» &7$message")

}