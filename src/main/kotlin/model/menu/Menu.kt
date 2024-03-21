package org.example.model.menu

abstract class Menu(
    open val number: Int,
    open val name: String,
    open val description: String,
) {
    open fun displayInfo(): String {
        val nameWithSpace = name.padEnd(14, ' ')

        return "$number. $nameWithSpace  |  $description"
    }
}