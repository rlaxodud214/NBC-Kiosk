package com.example.kiosk.view

import com.example.kiosk.util.BurgersMenu
import com.example.kiosk.util.MainMenu
import com.example.kiosk.util.SubMenu
import java.lang.StringBuilder

class OutputView {
    fun printMainMenuList(array: Array<MainMenu>) {
        println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n")
        println("[ SHAKESHACK MENU ]")

        array.forEach {
            it.run {
                val nameWithSpace = itemName.padEnd(14, ' ')
                println("$menuNumber. $nameWithSpace  |  $description")
            }
        }
    }

    fun printSubMenuList(seletedNumber: Int) {
        println("\n[ Burgers MENU ]")

        val sb = StringBuilder()

        when(seletedNumber) {
            1 -> BurgersMenu.values().forEach { sb.append(it) }
            2 -> {}
            3 -> {}
            4 -> {}
            else -> {}
        }

        println(sb.toString())
    }
}