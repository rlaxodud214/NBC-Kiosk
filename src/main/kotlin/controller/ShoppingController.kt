package org.example.controller

import org.example.InputState
import org.example.model.ShoppingBasket
import org.example.model.menu.SubMenu
import org.example.view.InputView
import org.example.view.OutputView

class ShoppingController(val shoppingBasket: ShoppingBasket) {
    fun runShopping(selectedMenu: SubMenu) {
        println(selectedMenu.displayInfo().substring(3))

        val inputNumber = InputView.inputMenuNumber("위 메뉴를 장바구니에 추가하시겠습니까? [1] 확인, [2] 취소")

        if (inputNumber == 1) {
            shoppingBasket.addItem(selectedMenu)
            println("${selectedMenu.name}가 장바구니에 추가되었습니다.\n")

            MainController.inputState = InputState.MAINMENU
            OutputView.printInputInfo()
        }

        if (inputNumber == 2) {
            MainController.inputState = InputState.SUBMENU
        }
    }
}