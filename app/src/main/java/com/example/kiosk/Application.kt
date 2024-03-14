package com.example.kiosk

import com.example.kiosk.controller.MainController
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val mainController = MainController(inputView, outputView)

    mainController.run()
}