package com.example.kiosk.view

import com.example.kiosk.model.Order
import com.example.kiosk.model.menu.Menu

class OutputView {
    fun printInputInfo() {
        println("[Hello] SHAKESHACK BURGER 에 오신걸 환영합니다.")
        println("[Info] 아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
    }

    // TODO: 파라미터 타입을 Food로 바꿔서 printMainMenuList, printSubMenuList 코드를 통합할 수 있을 것 같다!!
    // 상속 구조를 갖췄기 때문에 하나로 합칠 수 있구나 !!
    fun printMainMenuList(mainMenuList: List<Menu>, isEnableshoppingBasket: Boolean) {
        println("\n[ SHAKESHACK MENU ]")

        mainMenuList.forEach {
            println(it.displayInfo())
        }

        if (isEnableshoppingBasket == false) {
            println("0. Exit            |  프로그램 종료\n")
        }
    }

    fun printOrderMenuList(orderList: List<Order>) {
        println("\n[ ORDER MENU ]")

        orderList.forEach {
            println(it.displayInfo())
        }
    }

    fun printSubMenuList(subMenuList: List<Menu>) {
        println("\n[ Burgers MENU ]")

        subMenuList.forEach {
            println(it.displayInfo())
        }

        println("0. Back          | 뒤로가기\n")
    }
}