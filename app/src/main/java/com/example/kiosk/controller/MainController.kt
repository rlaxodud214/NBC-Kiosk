package com.example.kiosk.controller

import com.example.kiosk.model.SelectedMenuNumber
import com.example.kiosk.util.InputState
import com.example.kiosk.util.Validate
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView

class MainController(
    val inputView: InputView,
    val outputView: OutputView,
) {
    fun run() {
        val selectedMenuNumber = SelectedMenuNumber()

        while (inputState != InputState.DONE) {
            when (inputState) {
                // TODO : when절 조건에 따른 바디 함수로 빼기
                InputState.MAINMENU -> {
                    outputView.printMainMenuList()

                    val inputNumber = inputView.inputMenuNumber("Main")
                    Validate.isInMainMenuRange(inputNumber)
                    selectedMenuNumber.mainNumber = inputNumber

                    inputState = InputState.SUBMENU
                    isExit(inputNumber)
                }

                InputState.SUBMENU -> {
                    outputView.printSubMenuList(selectedMenuNumber.mainNumber)

                    val inputNumber = inputView.inputMenuNumber("Sub")
                    selectedMenuNumber.subNumber = inputNumber

                    isBack(selectedMenuNumber.subNumber)
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