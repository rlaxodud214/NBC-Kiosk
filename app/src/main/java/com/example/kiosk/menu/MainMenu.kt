package com.example.kiosk.menu

class MainMenu(
    val number: Int,
    val name: String,
    val description: String,
) {
    fun displayInfo(): String {
        val nameWithSpace = name.padEnd(14, ' ')

        return "$number. $nameWithSpace  |  $description"
    }
}