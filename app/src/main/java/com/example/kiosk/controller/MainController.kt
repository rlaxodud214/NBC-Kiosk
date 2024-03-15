package com.example.kiosk.controller

import com.example.kiosk.InputState
import com.example.kiosk.model.Balance
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

    fun run(balance: Balance) {
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
                    5 -> runOrder(balance)
                    6 -> cancleOrder()
                }
            }

            InputState.DONE -> return
        }
    }

    fun runOrder(balance: Balance) {
        outputView.printOrderInfo()
        val inputNumber = inputView.inputMenuNumber("1. order      2. back")

        when(inputNumber) {
            1 -> {
                // 현재 잔액 판단 -> 결제 or 잔액 부족 문구 출력
                val totalPrice = shoppingBasket.getTotalPrice()
                if (balance.money < totalPrice) {
                    println("현재 잔액은 ${balance}로 ${totalPrice - balance.money}\$가 부족해서 주문할 수 없습니다.")
                    return
                }
                println()
            }

            2 -> inputState = InputState.MAINMENU
        }

    }

    fun cancleOrder() {

    }

    companion object {
        var inputState = InputState.MAINMENU

        var userSelectNumbers = UserSelectNumbers()
        var isEnableShoppingBasket = false

        val shoppingBasket = ShoppingBasket()
    }
}