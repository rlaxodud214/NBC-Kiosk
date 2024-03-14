package com.example.kiosk.model

class Order(
    val menuNumber: Int,
    val menuName: String,
    val menuDescription: String,
) {
    fun displayInfo(): String {
        val nameWithSpace = menuName.padEnd(14, ' ')

        return "$menuNumber. $nameWithSpace  |  $menuDescription"
    }
}