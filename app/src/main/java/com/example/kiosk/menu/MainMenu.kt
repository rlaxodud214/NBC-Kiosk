package com.example.kiosk.menu

open class MainMenu(
    open val number: Int,
    open val name: String,
    open val description: String,
) {
    open fun displayInfo(): String {
        val nameWithSpace = name.padEnd(14, ' ')

        return "$number. $nameWithSpace  |  $description"
    }
}