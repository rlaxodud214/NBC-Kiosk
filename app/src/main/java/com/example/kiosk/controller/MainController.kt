package com.example.kiosk.controller

import com.example.kiosk.InputState
import com.example.kiosk.model.UserSelectNumber
import com.example.kiosk.model.menu.MainMenu
import com.example.kiosk.model.menu.SubMenu
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView

class MainController(
    val inputView: InputView,
    val outputView: OutputView,
) {
    fun run() {
        var userSelectNumber = UserSelectNumber(Int.MIN_VALUE)
        val menuController = MainMenuController(inputView, outputView)
        val subController = SubMenuController(inputView, outputView)

        outputView.printInputInfo()

        while (inputState != InputState.DONE) {
            when (inputState) {
                InputState.MAINMENU -> menuController.runMain(userSelectNumber)
                InputState.SUBMENU -> subController.runSub(userSelectNumber)
                InputState.DONE -> break
            }
        }
    }

    companion object {
        var inputState = InputState.MAINMENU
    }
}