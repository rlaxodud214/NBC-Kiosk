package com.example.kiosk.controller

import com.example.kiosk.InputState
import com.example.kiosk.model.ShoppingBasket
import com.example.kiosk.model.UserSelectNumber
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView

class MainController(
    inputView: InputView,
    outputView: OutputView,
) {
    var userSelectNumber = UserSelectNumber()
    val mainMenuController = MainMenuController(inputView, outputView)
    val subMenuController = SubMenuController(inputView, outputView, userSelectNumber)
    val shoppingBasket = ShoppingBasket()

    fun run() {
        when (inputState) {
            InputState.MAINMENU -> mainMenuController.runMain(userSelectNumber)
            InputState.SUBMENU -> subMenuController.runSub()

            InputState.SHOPPING -> {
                
            }

            InputState.DONE -> return
        }
    }

    companion object {
        var inputState = InputState.MAINMENU
    }
}