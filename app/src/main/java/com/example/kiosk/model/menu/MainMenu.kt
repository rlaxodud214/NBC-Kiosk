package com.example.kiosk.model.menu

open class MainMenu(
    override val number: Int,
    override val name: String,
    override val description: String,
) : Food(number, name, description) {
    override fun displayInfo(): String {
        val nameWithSpace = name.padEnd(14, ' ')

        return "$number. $nameWithSpace  |  $description"
    }
}