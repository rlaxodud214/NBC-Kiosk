package com.example.kiosk.view

import com.example.kiosk.menu.MainMenu
import com.example.kiosk.menu.SubMenu

class OutputView {
    fun printInputInfo() {
        println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
    }

    fun printMainMenuList(mainMenuList: List<MainMenu>) {
        println("\n[ SHAKESHACK MENU ]")

        mainMenuList.forEach {
            println(it.displayInfo())
        }

        println("0. Exit            |  프로그램 종료\n")
    }

    fun printSubMenuList(subMenuList: List<SubMenu>) {
        println("\n[ Burgers MENU ]")

        subMenuList.forEach {
            println(it.displayInfo())
        }

        println("0. Back          | 뒤로가기\n")
    }
}