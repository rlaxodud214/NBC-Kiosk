package com.example.kiosk.model.menu
abstract class Food(
    open val number: Int,
    open val name: String,
    open val description: String,
) {
    abstract fun displayInfo(): String
}