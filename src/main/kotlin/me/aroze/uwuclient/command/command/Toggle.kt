package me.aroze.uwuclient.command.command

import me.aroze.uwuclient.UwUClient.Companion.instance
import me.aroze.uwuclient.command.Command
import me.aroze.uwuclient.command.CommandInfo
import me.aroze.uwuclient.module.Module
import me.aroze.uwuclient.module.ModuleManager

@CommandInfo(
    name = "Toggle",
    description = "Toggles a module",
    aliases = ["t"]
)
object Toggle : Command() {

    override fun handle(commandName: String, args: Array<String>) {
        val module: Module = ModuleManager.getModule(args[0]) ?: return error("Module not found")
        module.toggle()
        instance.printWithPrefix(if (module.enabled) "&aEnabled" else "&cDisabled", "&d${module.name}")
    }

}