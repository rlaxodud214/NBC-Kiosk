package org.example.controller

import org.example.InputState
import org.example.config.MainManuData
import org.example.model.UserSelectNumbers
import org.example.view.InputView
import org.example.view.OutputView

class MainMenuController(
    val userSelectNumbers: UserSelectNumbers,
) {
    private val mainMenuData = MainManuData()

    fun runMain(isEnableShoppingBasket: Boolean) {
        printPrompt(isEnableShoppingBasket)

        inputValidate(isEnableShoppingBasket)

        nextInputState()

        isExit(userSelectNumbers.mainNumber)
    }

    private fun printPrompt(isEnableShoppingBasket: Boolean) {
        OutputView.printMenuList("SHAKESHACK", mainMenuData.mainMenuList, "0. Exit            |  프로그램 종료")

        if (isEnableShoppingBasket == true) {
            OutputView.printMenuList("OrderMenu", mainMenuData.orderList)
        }
    }

    private fun inputValidate(isEnableShoppingBasket: Boolean) {
        userSelectNumbers.run {
            mainNumber = InputView.inputMenuNumber("Main 메뉴를 선택해주세요")

            val validateLength =
                if (isEnableShoppingBasket) {
                    mainMenuData.mainMenuList.size + mainMenuData.orderList.size
                } else {
                    mainMenuData.mainMenuList.size
                }

            validateInRange(mainNumber, validateLength)
        }
    }

    private fun nextInputState() {
        if (userSelectNumbers.mainNumber in 5..6) {
            MainController.inputState = InputState.ORDER
        } else {
            MainController.inputState = InputState.SUBMENU
        }
    }

    private fun isExit(inputNumber: Int) {
        if (inputNumber == 0) {
            MainController.inputState = InputState.DONE
            println("exit complete")
        }
    }
}