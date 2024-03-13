package com.example.kiosk.menu

class SubMenu(
    val number: Int,
    val name: String,
    val price: Double,
    val description: String,
) {
    fun displayInfo(): String {
        val nameWithSpace = name.padEnd(14, ' ')

        return "$number. $nameWithSpace  |  $price$  |  $description"
    }
}