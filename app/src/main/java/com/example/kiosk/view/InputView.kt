package com.example.kiosk.view

class InputView {
    fun inputMenuNumber(type: String): Int {
        print("$type 메뉴를 선택해주세요 : ")
        val inputNumber = readLine()!!.toIntOrNull()

        return inputNumber ?: throw NumberFormatException(ERROR_TEXT)
    }

    companion object {
        const val ERROR_TEXT = "잘못된 문자를 입력했어요 다시 입력해주세요."
    }
}