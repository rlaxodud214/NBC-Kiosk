package org.example.view

import org.example.model.ShoppingBasket
import org.example.model.menu.Menu
import org.example.model.menu.SubMenu

object OutputView {
    fun printInputInfo() {
        println("[Hello] SHAKESHACK BURGER 에 오신걸 환영합니다.")
        println("[Info] 아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
    }

    fun printMenuList(type: String, menuList: List<Menu>, post: String? = null) {
        println("\n[ $type MENU ]")

        menuList.forEach {
            println(it.displayInfo())
        }

        post?.let { print(post) }.also { println() }
    }

    fun printMenu(selectedMenu: SubMenu) {
        println(selectedMenu.displayInfo().substring(3))
    }

    fun printOrderInfo(shoppingBasket: ShoppingBasket) {
        println("아래와 같이 주문 하시겠습니까?\n")

        println("[ Orders ]")
        shoppingBasket.getItemInfo().forEach {
            println(it.substring(3))
        }

        println("\n[ Total Price ]")
        println("${shoppingBasket.getTotalPrice()}$\n")
    }
}