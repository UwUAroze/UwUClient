package me.aroze.uwuclient.module.hud

import me.aroze.uwuclient.event.EventInfo
import me.aroze.uwuclient.event.events.Event2D
import me.aroze.uwuclient.module.Module
import me.aroze.uwuclient.module.ModuleInfo
import me.aroze.uwuclient.module.ModuleManager
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.ScaledResolution
import net.minecraft.client.renderer.GlStateManager

@ModuleInfo(
    name = "Hud",
    description = "Displays information on your screen"
)
object Hud : Module() {

    val animateIn = HashMap<String, Animate>()
    val animateOut = ArrayList<String>()
    var sortedModules = ArrayList<String>()

    init {
        enabled(true)
    }

    @EventInfo
    fun onEvent2D(event: Event2D) {

        val scaledResolution = event.scaledResolution

        GlStateManager.pushMatrix()
        GlStateManager.scale(2.0, 2.0, 2.0)
        mc.fontRendererObj.drawStringWithShadow("UwUClient", 5f, 5f, 0xffd6e5)
        GlStateManager.popMatrix()

        val modules = ArrayList<String>()

        for (module in ModuleManager.modules) {
            if (module.enabled) modules.add(module.name)
        }

        modules.sortWith(Comparator { o1, o2 ->
            Minecraft.getMinecraft().fontRendererObj.getStringWidth(o2) - Minecraft.getMinecraft().fontRendererObj.getStringWidth(o1)
        })

        for (module in modules.withIndex()) {
            mc.fontRendererObj.drawStringWithShadow(module.value, scaledResolution.scaledWidth - mc.fontRendererObj.getStringWidth(module.value) - 5f, 5f + mc.fontRendererObj.FONT_HEIGHT * module.index, 0xa38691)
//            if (!sortedModules.contains(module.value)) {
//                animateIn.put(module.value, Animate(scaledResolution.scaledWidth, 5f + mc.fontRendererObj.FONT_HEIGHT * module.index, width, 12, true, false))
//            }
        }

        this.sortedModules = modules

    }

}