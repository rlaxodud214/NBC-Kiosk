package com.example.kiosk.controller

import com.example.kiosk.InputState
import com.example.kiosk.model.ShoppingBasket
import com.example.kiosk.model.UserSelectNumbers
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView

class MainController(
    val inputView: InputView,
    val outputView: OutputView,
) {
    val mainMenuController = MainMenuController(inputView, outputView)
    val subMenuController = SubMenuController(inputView, outputView, userSelectNumbers)


    fun run() {
        when (inputState) {
            // main과 sub를 하나의 MenuController로 다루는 게 맞을까?
            InputState.MAINMENU -> mainMenuController.runMain()
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

            InputState.ORDER -> {
                when(userSelectNumbers.mainNumber) {
                    // 장바구니를 확인 후 주문합니다.
                    5 -> {
                        outputView.printOrderInfo()
                        val inputNumber = inputView.inputMenuNumber("1. order      2. back")
                    }
                    // 진행중인 주문을 취소합니다.
                    6 -> {

                    }
                }


            }

            InputState.DONE -> return
        }
    }

    companion object {
        var userSelectNumbers = UserSelectNumbers()
        val shoppingBasket = ShoppingBasket()

        var inputState = InputState.MAINMENU

        var isEnableShoppingBasket = false
    }
}