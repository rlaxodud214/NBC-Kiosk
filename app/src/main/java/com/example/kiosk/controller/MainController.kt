package com.example.kiosk.controller

import com.example.kiosk.InputState
import com.example.kiosk.model.ShoppingBasket
import com.example.kiosk.model.UserSelectNumber
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView

class MainController(
    val inputView: InputView,
    val outputView: OutputView,
) {
    var userSelectNumber = UserSelectNumber()
    val mainMenuController = MainMenuController(inputView, outputView)
    val subMenuController = SubMenuController(inputView, outputView, userSelectNumber)
    val shoppingBasket = ShoppingBasket()

    fun run() {
        when (inputState) {
            InputState.MAINMENU -> {
                mainMenuController.runMain(userSelectNumber, isEnableShoppingBasket)
            }

            InputState.SUBMENU -> subMenuController.runSub()

            InputState.SHOPPING -> {
                val item = subMenuController.chooseMenu

                println(item.displayInfo().substring(3))
                val inputNumber = inputView.inputMenuNumber("위 메뉴를 장바구니에 추가하시겠습니까? [1] 확인, [2] 취소")

                if (inputNumber == 1) {
                    isEnableShoppingBasket = true
                    shoppingBasket.addItem(item)
                    println("${item.name}가 장바구니에 추가되었습니다.\n")
                    inputState = InputState.MAINMENU
                    outputView.printInputInfo()
                }

                if (inputNumber == 2) {
                    inputState = InputState.SUBMENU
                }
            }

            InputState.DONE -> return
        }
    }

    companion object {
        var inputState = InputState.MAINMENU

        var isEnableShoppingBasket = false
    }
}