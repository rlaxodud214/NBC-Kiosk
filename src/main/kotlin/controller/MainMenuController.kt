package org.example.controller

import org.example.InputState
import org.example.config.MainMenuData
import org.example.configData.BACK_OR_EXIT_NUMBER
import org.example.model.UserSelectNumbers
import org.example.view.InputView
import org.example.view.OutputView

class MainMenuController(
    val userSelectNumbers: UserSelectNumbers,
) {
    private val mainMenuData = MainMenuData()

    fun run(isEnableShoppingBasket: Boolean): InputState {
        printPrompt(isEnableShoppingBasket)
        val inputNumber = inputNumberValidate(isEnableShoppingBasket)

        return nextInputState(inputNumber)
    }

    private fun printPrompt(isEnableShoppingBasket: Boolean) {
        OutputView.printMenuList(
            title = "SHAKESHACK",
            menuList = mainMenuData.mainMenuList,
            post = "${BACK_OR_EXIT_NUMBER}. Exit            |  프로그램 종료"
        )

        if (isEnableShoppingBasket == true) {
            OutputView.printMenuList(
                title = "OrderMenu",
                menuList = mainMenuData.orderList
            )
        }
    }

    private fun inputNumberValidate(isEnableShoppingBasket: Boolean): Int {
        val inputNumber = InputView.inputMenuNumber("Main 메뉴를 선택해주세요")

        var allowMaxNumber = mainMenuData.mainMenuList.size
        if (isEnableShoppingBasket == true) {
            allowMaxNumber += mainMenuData.orderList.size
        }

        val allowedRange = BACK_OR_EXIT_NUMBER..allowMaxNumber
        userSelectNumbers.run {
            validateInRange(inputNumber, allowedRange)
            mainNumber = inputNumber
        }

        return inputNumber
    }

    private fun nextInputState(inputNumber: Int): InputState {
        if (inputNumber in 5..6) {
            return InputState.ORDER
        }

        if (inputNumber == BACK_OR_EXIT_NUMBER) {
            println("exit complete")
            return InputState.DONE
        }

        return InputState.SUBMENU
    }
}