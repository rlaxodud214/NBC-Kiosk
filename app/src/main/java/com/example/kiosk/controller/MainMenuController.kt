package com.example.kiosk.controller

import com.example.kiosk.InputState
import com.example.kiosk.model.UserSelectNumber
import com.example.kiosk.model.menu.MainMenu
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView

class MainMenuController(
    val inputView: InputView,
    val outputView: OutputView,
) {
    fun runMain(userSelectNumber: UserSelectNumber) {
        outputView.printMainMenuList(mainMenuList)

        userSelectNumber.run {
            number = inputView.inputMenuNumber("Main")
            validateInRange(mainMenuList.size)
        }

        MainController.inputState = InputState.SUBMENU
        isExit(userSelectNumber.number)
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
    }
}