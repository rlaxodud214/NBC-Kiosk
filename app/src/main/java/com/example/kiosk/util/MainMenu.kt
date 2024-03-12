package com.example.kiosk.util

enum class MainMenu(val menuNumber: Int, val itemName: String, val description: String) {
    BURGERS(1, "Burgers", "앵거스 비프 통살을 다져 만든 버거"),
    FROZEN_CUSTARD(2, "Frozen Custard", "매장에서 신선하게 만드는 아이스크림"),
    DRINKS(3, "Drinks", "매장에서 직접 만드는 음료"),
    BEER(4, "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"),
    EXIT(0, "종료", "프로그램 종료");

    override fun toString(): String {
        return displayInfo()
    }

    private fun displayInfo(): String {
        val nameWithSpace = itemName.padEnd(14, ' ')

        return "$menuNumber. $nameWithSpace  |  $description" + "\n"
    }

    companion object {
        var UserMenuSelection = Int.MAX_VALUE
    }
}