package org.example.controller

import org.example.InputState
import org.example.configData.DECIMAL_PRECISION_FACTOR
import org.example.model.UserSelectNumbers
import org.example.model.data.OrderData
import org.example.model.data.ShoppingBasketData
import org.example.model.data.UserBalance
import org.example.view.InputView
import org.example.view.OutputView
import kotlin.math.roundToInt

class MainController() {
    private val userSelectNumbers = UserSelectNumbers()
    private var isEnableShoppingBasket = false
    private val shoppingBasket = ShoppingBasketData()
    private val orderList = mutableListOf<OrderData>()

    private val mainMenuController = MainMenuController(userSelectNumbers)
    private val subMenuController = SubMenuController(userSelectNumbers)
    private val shoppingController = ShoppingController(userSelectNumbers, shoppingBasket)

    fun run(balance: UserBalance) {
        when (inputState) {
            InputState.MAINMENU -> {
                mainMenuController.run(isEnableShoppingBasket)
            }

            InputState.SUBMENU -> subMenuController.run()
            InputState.SHOPPING -> {
                isEnableShoppingBasket = true
                shoppingController.run(subMenuController.chooseMenu)
            }

            InputState.ORDER -> {
                when (userSelectNumbers.mainNumber) {
                    5 -> runOrder(balance)
                    6 -> cancleOrder()
                }
                inputState = InputState.MAINMENU
            }

            InputState.DONE -> return
        }
    }

    fun runOrder(balance: UserBalance) {
        if (shoppingBasket.getItemInfo().size == 0) {
            println("[no shopping] 장바구니가 비어있어요!")
            return
        }

        OutputView.printOrderInfo(shoppingBasket)
        val inputNumber = InputView.inputMenuNumber("1. order      2. back")

        if (inputNumber != 1) {
            return
        }

        val totalPrice = shoppingBasket.getTotalPrice()
        if (balance.money < totalPrice) {
            println("현재 잔액은 ${balance}로 ${cutDecimal(balance.money - totalPrice) * -1}\$가 부족해서 주문할 수 없습니다.")
            return
        }

        balance.money = cutDecimal(balance.money - totalPrice)
        println("결제 후, 남은 잔액은 ${balance.money}\$입니다.")

        val orderObject = OrderData(
            orderList.size + 1,
            // cloneable 상속받도록 하고 copy관련 메서드 오버라이딩 해봤지만, DeepCopy 실패
            shoppingBasket.getItem().toList().toMutableList(), // DeepCopy 해야함.
            false
        )
        orderList.add(orderObject)

        shoppingBasket.resetItems()

        println("[ OrderList ]")
        println(orderObject)
    }

    fun cancleOrder() {
        // 1. 결제한 리스트를 출력한다.

        // 2. 취소할 주문번호를 입력 받는다.

        // 3. "아래의 주문을 취소하시겠습니까?

        // 4. [1] 예, [2] 아니요 입력 받기

        // 4-[1]. 주문 번호에 접근해서 isCancel값 true로 변경하기

        // 4-[2]. return -> 어차피 함수의 마지막이라 굳이 안해도 됨
    }

    companion object {
        var inputState = InputState.MAINMENU

        fun cutDecimal(number: Double): Double {
            return (DECIMAL_PRECISION_FACTOR * (number).roundToInt()) / DECIMAL_PRECISION_FACTOR
        }
    }
}