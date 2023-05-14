package me.aroze.uwuclient.command

import me.aroze.arozeutils.kotlin.extension.prettify
import me.aroze.uwuclient.UwUClient.Companion.instance
import net.minecraft.client.Minecraft

abstract class Command {
    protected val mc: Minecraft = Minecraft.getMinecraft()

    val name: String
    val description: String
    val aliases: Array<String>

    init {
        val commandInfo = this.javaClass.getAnnotation(CommandInfo::class.java)
            ?: throw Exception("CommandInfo annotation not found on command ${this.javaClass.simpleName}")

        name = commandInfo.name
        description = commandInfo.description
        aliases = commandInfo.aliases
    }

    abstract fun handle(commandName: String, args: Array<String>)
    fun addAlias(alias: String) = aliases.plus(alias)
    fun addMessage(message: String) = instance.printToChat(message)
    fun error(message: String) = instance.printWithPrefix(message, "&c${name.prettify()}")
    fun info(message: String) = instance.printWithPrefix(message, "&d${name.prettify()}")
}