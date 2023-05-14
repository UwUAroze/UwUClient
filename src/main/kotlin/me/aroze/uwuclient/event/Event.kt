package me.aroze.uwuclient.event

open class Event() {
    var cancelled = false

    fun call() = EventManager.runEvent(this)

}