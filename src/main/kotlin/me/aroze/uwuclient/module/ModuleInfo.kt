package me.aroze.uwuclient.module

annotation class ModuleInfo(
    val name: String = "New Module",
    val description: String = "No description provided",
    val category: ModuleCategory = ModuleCategory.MISC,
    val key: Int = 0,
)
