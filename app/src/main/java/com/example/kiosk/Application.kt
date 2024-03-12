package com.example.kiosk

import com.example.kiosk.util.MainMenu
import com.example.kiosk.util.Validate
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    outputView.printMainMenuList(MainMenu.values())

    val inputNumber = inputView.inputMainMenu()
    require(Validate.isInMenuRange(inputNumber)) {
        "잘못된 숫자를 입력했어요 다시 입력해주세요."
    }

    // TODO: 이후 while에서 break 추가
    if (inputNumber == 0) { }

    outputView.printSubMenuList(inputNumber)
}