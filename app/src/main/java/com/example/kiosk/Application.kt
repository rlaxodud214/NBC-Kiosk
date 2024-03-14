package com.example.kiosk

import com.example.kiosk.controller.MainController
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView
import java.lang.Exception

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val mainController = MainController(inputView, outputView)

    outputView.printInputInfo()

    while (MainController.inputState != InputState.DONE) {
        try {
            mainController.run()
        } catch (e: Exception) {
            val errorMessage = e.message?.let { it } ?: "[Fix] 원인 모를 오류 발생"

            mainController.userSelectNumber.subNumber = Int.MIN_VALUE
            println("$errorMessage \n")
        }
    }
}