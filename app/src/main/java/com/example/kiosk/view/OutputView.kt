package com.example.kiosk.view

import com.example.kiosk.util.MainCategory

class OutputView {
    fun displayMainCategory() {
        println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n")
        println("[ SHAKESHACK MENU ]")

        MainCategory.values().forEach {
            it.run {
                val nameWithSpace = name.replace('_', ' ').padEnd(14, ' ')
                println(String.format("${ordinal + 1}. $nameWithSpace  |  $description"))
            }
        }
    }
}