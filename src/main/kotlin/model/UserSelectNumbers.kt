package org.example.model

class UserSelectNumbers(
    var mainNumber: Int = Int.MIN_VALUE,
) {
    fun validateInRange(number: Int, allowedRange: IntRange) {
        require(number in allowedRange) {
            "[invalid char] 잘못된 문자를 입력했어요 다시 입력해주세요."
        }
    }
}