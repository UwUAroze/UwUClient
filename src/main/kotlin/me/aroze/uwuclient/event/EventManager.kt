package me.aroze.uwuclient.event

import java.lang.reflect.Method

object EventManager {
    private val registeredObjects = ArrayList<Any>()
    private val registeredSenders = ArrayList<EventSender>()

    fun register(`object`: Any) {
        if (isRegistered(`object`)) {
            return
        }
        registeredObjects.add(`object`)
    }

    fun unregister(`object`: Any) {
        if (!isRegistered(`object`)) {
            return
        }
        registeredObjects.remove(`object`)
    }

    fun isRegistered(`object`: Any): Boolean {
        return registeredObjects.contains(`object`)
    }

    fun runEvent(event: Event) {
        val registeredObjects = ArrayList(this.registeredObjects)
        for (obj in registeredObjects) {
            for (method in getMethods(obj::class.java)) {
                if (method.parameterTypes.size == 1 && method.isAnnotationPresent(EventInfo::class.java) &&
                    (method.parameterTypes[0] == event::class.java || method.parameterTypes[0] == Event::class.java)
                ) {
                    EventSender(event, method, obj)
                }
            }
        }
    }

    fun getMethods(clazz: Class<*>): Array<Method> {
        return clazz.methods
    }

}