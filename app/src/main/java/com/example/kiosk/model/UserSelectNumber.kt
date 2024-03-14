package com.example.kiosk.model

class UserSelectNumber(var number: Int) {
    fun validateInRange(length: Int) {
        require(number in IntRange(0, length)) {
            "[invalid char] 잘못된 문자를 입력했어요 다시 입력해주세요."
        }
    }
}