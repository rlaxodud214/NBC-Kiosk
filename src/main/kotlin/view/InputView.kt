package org.example.view

class InputView {
    fun inputMenuNumber(prompt: String): Int {
        print("$prompt: ")
        val inputNumber = readLine()!!.toIntOrNull()

        println()
        return inputNumber ?: throw NumberFormatException(ERROR_TEXT)
    }

    companion object {
        const val ERROR_TEXT = "[E] 잘못된 문자를 입력했어요 다시 입력해주세요."
    }
}