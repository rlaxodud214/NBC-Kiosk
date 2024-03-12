package com.example.kiosk.util

object Validate {
    val mainMenuRange = IntRange(1, 5)

    fun isInMenuRange(number: Int) = if (number in mainMenuRange) true else false
}