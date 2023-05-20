package me.aroze.uwuclient.util

class TimerMS {

    var lastMS: Long = 0

    fun getCurrentMS() = System.nanoTime() / 1000000L
    fun hasReached(milliseconds: Long) = getCurrentMS() - lastMS >= milliseconds
    fun hasTimeReached(delay: Long): Boolean = System.currentTimeMillis() - lastMS >= delay
    fun getDelay() = System.currentTimeMillis() - lastMS
    fun reset() { lastMS = getCurrentMS() }

}