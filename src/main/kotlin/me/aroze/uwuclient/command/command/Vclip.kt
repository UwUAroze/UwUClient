package me.aroze.uwuclient.command.command

import me.aroze.uwuclient.UwUClient.Companion.instance
import me.aroze.uwuclient.command.Command
import me.aroze.uwuclient.command.CommandInfo

@CommandInfo(
    name = "vclip",
    description = "Teleports you vertically",
)
object Vclip : Command() {
    override fun handle(commandName: String, args: Array<String>) {
        if (args.isEmpty()) {
            error("Usage: .vclip <amount>")
            return
        }

        val amount = args[0].toDoubleOrNull() ?: run {
            error("Invalid amount")
            return
        }

        mc.thePlayer!!.setPosition(mc.thePlayer!!.posX, mc.thePlayer!!.posY + amount, mc.thePlayer!!.posZ)
        info("Vertically clipped by $amount blocks")

    }
}