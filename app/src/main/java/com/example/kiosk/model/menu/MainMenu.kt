package com.example.kiosk.model.menu

open class MainMenu(
    override val number: Int,
    override val name: String,
    override val description: String,
) : Menu(number, name, description)