package org.example.controller

import org.example.InputState
import org.example.config.MainMenuData
import org.example.model.UserSelectNumbers
import org.example.view.InputView
import org.example.view.OutputView

class MainMenuController(
    val userSelectNumbers: UserSelectNumbers,
) {
    private val mainMenuData = MainMenuData()

    fun run(isEnableShoppingBasket: Boolean) {
        printPrompt(isEnableShoppingBasket)
        val inputNumber = inputNumberValidate(isEnableShoppingBasket)

        nextInputState(inputNumber)
    }

    private fun printPrompt(isEnableShoppingBasket: Boolean) {
        OutputView.printMenuList("SHAKESHACK", mainMenuData.mainMenuList, "0. Exit            |  프로그램 종료")

        if (isEnableShoppingBasket == true) {
            OutputView.printMenuList("OrderMenu", mainMenuData.orderList)
        }
    }

    private fun inputNumberValidate(isEnableShoppingBasket: Boolean): Int {
        val inputNumber = InputView.inputMenuNumber("Main 메뉴를 선택해주세요")

        var validateLength = mainMenuData.mainMenuList.size
        if (isEnableShoppingBasket == true) {
            validateLength += mainMenuData.orderList.size
        }

        userSelectNumbers.run {
            validateInRange(inputNumber, validateLength)
            mainNumber = inputNumber
        }

        return inputNumber
    }

    private fun nextInputState(inputNumber: Int) {
        if (inputNumber in 5..6) {
            MainController.inputState = InputState.ORDER
            return
        }
        MainController.inputState = InputState.SUBMENU

        if (inputNumber == 0) {
            MainController.inputState = InputState.DONE
            println("exit complete")
        }
    }
}