package com.example.kiosk.controller

import com.example.kiosk.InputState
import com.example.kiosk.menu.MainMenu
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView

class MainController(
    val inputView: InputView,
    val outputView: OutputView,
) {
    fun run() {
        var inputNumber = Int.MIN_VALUE

        while (inputState != InputState.DONE) {
            when (inputState) {
                // TODO : when절 조건에 따른 바디 함수로 빼기
                InputState.MAINMENU -> {
                    outputView.printMainMenuList()

                    inputNumber = inputView.inputMenuNumber("Main")

                    inputState = InputState.SUBMENU

                    isExit(inputNumber)
                }

                InputState.SUBMENU -> {
                    outputView.printSubMenuList(inputNumber)

                    inputNumber = inputView.inputMenuNumber("Sub")

                    isBack(inputNumber)
                }

                InputState.DONE -> break
            }
        }
    }

    fun isExit(inputNumber: Int) {
        if (inputNumber == 0) {
            inputState = InputState.DONE
            println("exit complete")
        }
    }

    fun isBack(inputNumber: Int) {
        if (inputNumber == 0) {
            inputState = InputState.MAINMENU
            println("back complete")
        }
    }

    companion object {
        var inputState = InputState.MAINMENU
    }
}