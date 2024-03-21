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
    lateinit var subMenuList: List<SubMenu>
    lateinit var chooseMenu: SubMenu
    private val subMenuData = SubMenuData()

    fun runSub() {
        subMenuList = subMenuData.subMenuList[userSelectNumber.mainNumber - 1]

        OutputView.printMenuList(
            subMenuData.menuPromptList[userSelectNumber.mainNumber],
            subMenuList,
            "0. Back          | 뒤로가기\n"
        )

        userSelectNumber.run {
            subNumber = InputView.inputMenuNumber("Sub 메뉴를 선택해주세요")
            validateInRange(subNumber, subMenuList.size)
            if (subNumber == 0) {
                back()
            } else {
                chooseMenu = subMenuList[subNumber - 1]
                MainController.inputState = InputState.SHOPPING
            }
        }
    }

    private fun back() {
        MainController.inputState = InputState.MAINMENU
        println("back complete\n")
    }
}