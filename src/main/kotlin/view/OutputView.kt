package org.example.view

import org.example.model.data.ShoppingBasketData
import org.example.model.menu.Menu
import org.example.model.menu.SubMenu

object OutputView {
    fun printErrorMessage(e: Exception) {
        val errorMessage = e.message?.let { it } ?: "[Fix] 원인 모를 오류 발생"
        println("$errorMessage \n")
    }

    fun printInputInfo() {
        println("[Hello] SHAKESHACK BURGER 에 오신걸 환영합니다.")
        println("[Info] 아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
    }

    fun printMenuList(title: String, menuList: List<Menu>, post: String? = null) {
        println("\n[ $title MENU ]")

        menuList.forEach {
            println(it.displayInfo())
        }

        post?.let { print(post) }.also { println() }
    }

    fun printMenu(selectedMenu: SubMenu) {
        println(selectedMenu.displayInfo().substring(3))
    }

    fun printOrderInfo(shoppingBasket: ShoppingBasketData) {
        println("아래와 같이 주문 하시겠습니까?\n")

        println("[ Orders ]")
        shoppingBasket.getItemInfo().forEach {
            println(it.substring(3))
        }

        println("\n[ Total Price ]")
        println("${shoppingBasket.getTotalPrice()}$\n")
    }
}