package com.example.kiosk.view

import com.example.kiosk.controller.MainController.Companion.shoppingBasket
import com.example.kiosk.model.menu.Menu

class OutputView {
    fun printInputInfo() {
        println("[Hello] SHAKESHACK BURGER 에 오신걸 환영합니다.")
        println("[Info] 아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
    }

    fun printMenuList(type: String, menuList: List<Menu>, post: String? = null) {
        println("\n[ $type MENU ]")

        menuList.forEach {
            println(it.displayInfo())
        }

        post?.let { println(post) }
    }

    fun printOrderInfo() {
        if (shoppingBasket.getItemInfo().size == 0) {
            println("[no shopping] 장바구니가 비어있어요!")
            return
        }

        println("아래와 같이 주문 하시겠습니까?\n")

        println("[ Orders ]")
        shoppingBasket.getItemInfo().forEach {
            println(it.substring(3))
        }

        println("\n[ Total Price ]")
        println("${shoppingBasket.getTotalPrice()}$\n")
    }
}