package org.example.controller

import org.example.InputState
import org.example.model.UserSelectNumbers
import org.example.model.data.ShoppingBasketData
import org.example.model.menu.SubMenu
import org.example.view.InputView
import org.example.view.OutputView

class ShoppingController(val userSelectNumber: UserSelectNumbers, val shoppingBasket: ShoppingBasketData) {
    fun run(selectedMenu: SubMenu) {
        OutputView.printMenu(selectedMenu)
        val inputNumber = inputNumberValidate()

        nextInputState(selectedMenu, inputNumber)
    }

    private fun inputNumberValidate(): Int {
        val inputNumber = InputView.inputMenuNumber("위 메뉴를 장바구니에 추가하시겠습니까? [1] 확인, [2] 취소")

        val allowedRange = SHOPPING_ADD_ALLOW..SHOPPING_ADD_CANCLE
        userSelectNumber.validateInRange(inputNumber, allowedRange)

        return inputNumber
    }

    private fun nextInputState(selectedMenu: SubMenu, inputNumber: Int) {
        if (inputNumber == SHOPPING_ADD_CANCLE) {
            MainController.inputState = InputState.SUBMENU
            return
        }

        shoppingProcessing(selectedMenu)

        MainController.inputState = InputState.MAINMENU
        OutputView.printInputInfo()
    }

    private fun shoppingProcessing(selectedMenu: SubMenu) {
        shoppingBasket.addItem(selectedMenu)
        println("${selectedMenu.name}가 장바구니에 추가되었습니다.\n")
    }

    companion object {
        private const val SHOPPING_ADD_ALLOW = 1
        private const val SHOPPING_ADD_CANCLE = 2
    }
}