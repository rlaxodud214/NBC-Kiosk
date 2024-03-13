package com.example.kiosk.controller

import com.example.kiosk.InputState
import com.example.kiosk.menu.MainMenu
import com.example.kiosk.menu.SubMenu
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView

class MainController(
    val inputView: InputView,
    val outputView: OutputView,
) {
    fun run() {
        var inputNumber = Int.MIN_VALUE
        outputView.printInputInfo()

        while (inputState != InputState.DONE) {
            when (inputState) {
                // TODO : when절 조건에 따른 바디 함수로 빼기
                InputState.MAINMENU -> {
                    outputView.printMainMenuList(mainMenuList)

                    inputNumber = inputView.inputMenuNumber("Main")

                    inputState = InputState.SUBMENU

                    isExit(inputNumber)
                }

                InputState.SUBMENU -> {
                    val obj = when(inputNumber) {
                        1 -> subMenuListBurger
                        2 -> subMenuListPizza
                        3 -> subMenuListIce
                        else -> throw Exception("asd")
                    }
                    outputView.printSubMenuList(obj)

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

        val mainMenuList = listOf(
            MainMenu(1, "Burgers", "앵거스 비프 통살을 다져만든 버거"),
            MainMenu(2, "Pizza", "신선한 토핑이 올라간 피자"),
            MainMenu(3, "Drinks", "매장에서 직접 만드는 음료"),
            MainMenu(4, "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"),
        )

        val subMenuListBurger = listOf(
            SubMenu(1, "Burger1", 6.9, "Burger_Info1"),
            SubMenu(2, "Burger2", 8.9, "Burger_Info2"),
            SubMenu(3, "Burger3", 9.4, "Burger_Info3"),
            SubMenu(4, "Burger4", 6.9, "Burger_Info4"),
            SubMenu(5, "Burger5", 5.4, "Burger_Info5"),
        )

        val subMenuListPizza = listOf(
            SubMenu(1, "Pizza1", 16.9, "Pizza_Info1"),
            SubMenu(2, "Pizza2", 18.9, "Pizza_Info2"),
            SubMenu(3, "Pizza3", 19.4, "Pizza_Info3"),
            SubMenu(4, "Pizza4", 16.9, "Pizza_Info4"),
            SubMenu(5, "Pizza5", 15.4, "Pizza_Info5"),
        )

        val subMenuListIce = listOf(
            SubMenu(1, "Ice1", 3.9, "Ice_Info1"),
            SubMenu(2, "Ice2", 4.9, "Ice_Info2"),
            SubMenu(3, "Ice3", 3.4, "Ice_Info3"),
            SubMenu(4, "Ice4", 3.8, "Ice_Info4"),
            SubMenu(5, "Ice5", 5.4, "Ice_Info5"),
        )
    }
}