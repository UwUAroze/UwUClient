package me.aroze.uwuclient.event.events

import me.aroze.uwuclient.event.Event
import net.minecraft.network.play.server.S02PacketChat
import net.minecraft.util.IChatComponent

class EventPacketChat(var s02PacketChat: S02PacketChat, var chatComponent: IChatComponent) : Event() {

}