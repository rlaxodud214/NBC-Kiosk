package com.example.kiosk.util

interface SubMenu {
    fun displayInfo(): String

    val menuNumber: Int
    val menuName: String
    val price: Double
    val description: String
}