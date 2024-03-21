package org.example.controller

import org.example.InputState
import org.example.config.SubMenuData
import org.example.model.UserSelectNumbers
import org.example.model.menu.SubMenu
import org.example.view.InputView
import org.example.view.OutputView

class SubMenuController(
    val userSelectNumber: UserSelectNumbers,
) {
    val subMenuList: List<SubMenu> by lazy {
        subMenuData.subMenuList[userSelectNumber.mainNumber - 1]
    }

    lateinit var chooseMenu: SubMenu
    private val subMenuData = SubMenuData()

    fun run() {
        printPrompt()
        val inputNumber = inputNumberValidate()

        nextInputState(inputNumber)
    }

    private fun printPrompt() {
        OutputView.printMenuList(
            subMenuData.menuPromptList[userSelectNumber.mainNumber],
            subMenuList,
            "0. Back          | 뒤로가기\n"
        )
    }

    private fun inputNumberValidate(): Int {
        val inputNumber = InputView.inputMenuNumber("Sub 메뉴를 선택해주세요")

        userSelectNumber.validateInRange(inputNumber, subMenuList.size)

        return inputNumber
    }

    private fun nextInputState(inputNumber: Int) {
        if (inputNumber == 0) {
            MainController.inputState = InputState.MAINMENU
            println("back complete\n")
            return
        }

        chooseMenu = subMenuList[inputNumber - 1]
        MainController.inputState = InputState.SHOPPING
    }
}