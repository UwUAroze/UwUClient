package me.aroze.uwuclient.event

import java.lang.reflect.Method

/**
 * The class used to send all events.
 *
 * @author Nick
 */
class EventSender(
    /** The event to send */
    private val event: Event,
    /** The method to send */
    private val method: Method,
    /** The object to send */
    private val obj: Any
) {

    /**
     * To Avoid one class running too many events at the same time.
     *
     * @param event The event to run.
     * @param method The method to run.
     * @param parent The object to run the method on.
     */
    init {
        runEvent()
    }

    /**
     * To run the event.
     */
    @Synchronized
    fun runEvent() {
        try {
            if (!method.isAccessible) method.isAccessible = true
            if (!hasAnnotation(method, EventInfo::class.java)) return
            if (getMethodParameterType(method, 0) != event.javaClass) return

            method.invoke(obj, event)

        } catch (ignored: Exception) { /* */ }
    }

    /**
     * Checks if a method has an annotation.
     *
     * @param method The method to check.
     * @param annotation The annotation to check for.
     * @return If the method has the annotation.
     */
    fun hasAnnotation(method: Method, annotation: Class<EventInfo>): Boolean {
        return method.isAnnotationPresent(annotation)
    }

    /**
     * Gets parameters from a method.
     *
     * @param method The method to get the parameters from.
     * @param index The index of the parameter.
     * @return The parameter.
     */
    fun getMethodParameterType(method: Method, index: Int): Class<*> {
        return method.parameterTypes[index]
    }

}