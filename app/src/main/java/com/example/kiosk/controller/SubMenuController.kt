package com.example.kiosk.controller

import com.example.kiosk.InputState
import com.example.kiosk.model.UserSelectNumber
import com.example.kiosk.model.menu.SubMenu
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView

class SubMenuController(
    val inputView: InputView,
    val outputView: OutputView,
) {
    fun runSub(userSelectNumber: UserSelectNumber) {
        val obj = when (userSelectNumber.number) {
            1 -> subMenuListBurger
            2 -> subMenuListPizza
            3 -> subMenuListIce
            // TODO: 한글 출력 오류가 있어 [eng] 추가 작성함 - 해결을 위해 5가지 시도를 했지만, 해결되지 않음
            else -> throw Exception("[not subMenu] 입력된 메뉴는 존재하지 않습니다.")
        }
        outputView.printSubMenuList(obj)

        userSelectNumber.run {
            number = inputView.inputMenuNumber("Sub")
            validateInRange(obj.size)
        }

        isBack(userSelectNumber.number)
    }

    private fun isBack(inputNumber: Int) {
        if (inputNumber == 0) {
            MainController.inputState = InputState.MAINMENU
            println("back complete")
        }
    }

    companion object {
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