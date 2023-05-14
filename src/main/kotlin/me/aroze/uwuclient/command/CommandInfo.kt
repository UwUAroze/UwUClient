package me.aroze.uwuclient.command

annotation class CommandInfo(
    val name: String,
    val description: String = "No description provided.",
    val aliases: Array<String> = [],
)
