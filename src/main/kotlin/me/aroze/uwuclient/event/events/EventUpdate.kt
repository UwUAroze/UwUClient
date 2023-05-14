package me.aroze.uwuclient.event.events

import me.aroze.uwuclient.event.Event

class EventUpdate(
    var x: Double, var y: Double, var z: Double,
    var yaw: Float, var pitch: Float, var onGround: Boolean,
    var pre: Boolean
) : Event() {

}