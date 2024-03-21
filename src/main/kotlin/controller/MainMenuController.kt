package org.example.controller

import org.example.InputState
import org.example.config.MainManuData
import org.example.model.ShoppingBasket
import org.example.model.UserSelectNumbers
import org.example.view.InputView
import org.example.view.OutputView

class MainMenuController(
    val inputView: InputView,
    val outputView: OutputView,
    val userSelectNumbers: UserSelectNumbers,
) {
    private val mainMenuData = MainManuData()

    fun runMain() {
        val isEnableShoppingBasket = ShoppingBasket.isEnableShopping()

        // TODO: (Fix)결제 후, 장바구니 목록이 초기화 되니까 MainMenu에서 OrderMenu 출력이 되지 않음
        // val isEnableOrder = orderData 객체가 여기 없음 -> 또 파라미터로 가져와야 하나,,,

        outputView.printMenuList("SHAKESHACK", mainMenuData.mainMenuList, "0. Exit            |  프로그램 종료")
        if (isEnableShoppingBasket == true) {
            outputView.printMenuList("OrderMenu", mainMenuData.orderList)
        }

        userSelectNumbers.run {
            mainNumber = inputView.inputMenuNumber("Main 메뉴를 선택해주세요")

            val validateLength =
                if (isEnableShoppingBasket) {
                    mainMenuData.mainMenuList.size + mainMenuData.orderList.size
                } else {
                    mainMenuData.mainMenuList.size
                }
            validateInRange(mainNumber, validateLength)
        }

        if (userSelectNumbers.mainNumber in 5..6) {
            MainController.inputState = InputState.ORDER
        } else {
            MainController.inputState = InputState.SUBMENU
        }

        isExit(userSelectNumbers.mainNumber)
    }

    private fun isExit(inputNumber: Int) {
        if (inputNumber == 0) {
            MainController.inputState = InputState.DONE
            println("exit complete")
        }
    }
}