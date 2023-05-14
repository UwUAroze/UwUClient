package me.aroze.uwuclient.command

import me.aroze.arozeutils.minecraft.generic.coloured
import me.aroze.uwuclient.UwUClient.Companion.instance
import me.aroze.uwuclient.command.command.Toggle
import me.aroze.uwuclient.command.command.Vclip
import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.EventManager
import me.aroze.uwuclient.event.events.EventPlayerChat

object CommandManager {

    val commands = ArrayList<Command>()

    init {
        EventManager.register(this)
    }

    @EventInfo
    fun onPlayerChat(event: EventPlayerChat) {
        var message = event.message

        if (!message.startsWith(".")) return
        event.cancelled = true

        var messages = message.split(" ")
        val commandName = messages[0].substring(1)

        messages = messages.drop(1)

        var foundCommand = false
        for (command in commands) {
            if (!command.name.equals(commandName, true) && !command.aliases.contains(commandName)) continue
            foundCommand = true
            command.handle(commandName, messages.toTypedArray())
        }

        if (!foundCommand) instance.printWithPrefix("Invalid command")

    }

    fun register(vararg command: Command) = commands.addAll(command)

    fun registerCommands() {
        register(
            Vclip, Toggle
        )
    }

}