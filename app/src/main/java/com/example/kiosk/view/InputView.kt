package com.example.kiosk.view

class InputView {
    fun inputMainMenu(): Int {
        print("메뉴를 입력해주세요 : ")

        val inputMenu = readLine()!!.toIntOrNull() ?: Int.MAX_VALUE

        inputMenu?.let {
            return it
        }

        return throw NumberFormatException("잘못된 문자를 입력했어요 다시 입력해주세요.")
    }
}