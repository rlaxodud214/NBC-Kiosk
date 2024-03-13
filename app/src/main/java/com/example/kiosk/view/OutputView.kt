package com.example.kiosk.view

import com.example.kiosk.model.menu.BurgersMenu
import com.example.kiosk.model.menu.MainMenu

class OutputView {
    // 기존의 value 파라미터는 사용자마다 다르게 보여주어야 하는 데이터가 아니므로 제거함
    fun printMainMenuList() {
        println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n")
        println("[ SHAKESHACK MENU ]")

        MainMenu.values().forEach {
            it.run {
                val nameWithSpace = menuName.padEnd(14, ' ')
                println("$menuNumber. $nameWithSpace  |  $description")
            }
        }
    }

    fun printSubMenuList(seletedNumber: Int) {
        println("\n[ Burgers MENU ]")

        // TODO: 다른 subMenu도 채워주기(예시 없음 [자유])
        when (seletedNumber) {
            1 -> BurgersMenu.values().forEach {
                printSubMenu(it)
            }
            2 -> {}
            3 -> {}
            4 -> {}
            else -> {}
        }
    }

    private fun printSubMenu(burgersMenu: BurgersMenu) {
        burgersMenu.run {
            val nameWithSpace = menuName.padEnd(14, ' ')

            val subMenuInfo = if (price != 0.0) {
                "$menuNumber. $nameWithSpace  |  $price$  |  $description"
            } else {
                "$menuNumber. $nameWithSpace  |  $description"
            }

            println(subMenuInfo)
        }
    }
}