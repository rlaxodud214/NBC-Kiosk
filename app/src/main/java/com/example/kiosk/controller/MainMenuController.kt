package com.example.kiosk.controller

import com.example.kiosk.InputState
import com.example.kiosk.controller.MainController.Companion.isEnableShoppingBasket
import com.example.kiosk.controller.MainController.Companion.userSelectNumbers
import com.example.kiosk.model.menu.OrderMenu
import com.example.kiosk.model.menu.MainMenu
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView

class MainMenuController(
    val inputView: InputView,
    val outputView: OutputView,
) {
    fun runMain() {
        outputView.printMenuList("SHAKESHACK", mainMenuList, "0. Exit            |  프로그램 종료")
        if (isEnableShoppingBasket == true) {
            outputView.printMenuList("OrderMenu", orderList)
        }

        userSelectNumbers.run {
            mainNumber = inputView.inputMenuNumber("Main 메뉴를 선택해주세요")

            val validateLength = if (isEnableShoppingBasket) mainMenuList.size + orderList.size else mainMenuList.size
            validateInRange(mainNumber, validateLength)
        }

        if (userSelectNumbers.mainNumber in 5..6) {
            MainController.inputState = InputState.ORDER
        } else {
            MainController.inputState = InputState.SUBMENU
        }

        if (isEnableShoppingBasket == false) {
            isExit(userSelectNumbers.mainNumber)
        }
    }

    private fun isExit(inputNumber: Int) {
        if (inputNumber == 0) {
            MainController.inputState = InputState.DONE
            println("exit complete")
        }
    }

    companion object {
        val mainMenuList = listOf(
            MainMenu(1, "Burgers", "앵거스 비프 통살을 다져만든 버거"),
            MainMenu(2, "Pizza", "신선한 토핑이 올라간 피자"),
            MainMenu(3, "Drinks", "매장에서 직접 만드는 음료"),
            MainMenu(4, "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"),
        )

        val orderList = listOf(
            OrderMenu(5, "OrderMenu", "장바구니를 확인 후 주문합니다."),
            OrderMenu(6, "Cancel", "진행중인 주문을 취소합니다.")
        )
    }
}