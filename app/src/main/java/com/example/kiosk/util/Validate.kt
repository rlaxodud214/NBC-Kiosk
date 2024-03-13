package com.example.kiosk.util

object Validate {
    val mainMenuRange = IntRange(0, 5)

    fun isInMainMenuRange(number: Int) {
        require(number in mainMenuRange) {
            "잘못된 숫자를 입력했어요 다시 입력해주세요."
        }
    }
}