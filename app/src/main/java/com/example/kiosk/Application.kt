package com.example.kiosk

import com.example.kiosk.controller.MainController
import com.example.kiosk.controller.MainController.Companion.userSelectNumbers
import com.example.kiosk.model.Balance
import com.example.kiosk.view.InputView
import com.example.kiosk.view.OutputView
import kotlin.math.roundToInt
import kotlin.random.Random

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val mainController = MainController(inputView, outputView)

    outputView.printInputInfo()

    val userBalance = Balance(
        Random.nextDouble(150.0).roundToInt() / 10.0
    )
    println("현재 잔액: $userBalance")

    while (MainController.inputState != InputState.DONE) {
        try {
            mainController.run(userBalance)
        } catch (e: Exception) {
            val errorMessage = e.message?.let { it } ?: "[Fix] 원인 모를 오류 발생"
            initState()
            println("$errorMessage \n")
        }
    }
}

fun initState() {
    when (MainController.inputState) {
        InputState.SUBMENU -> userSelectNumbers.subNumber = Int.MIN_VALUE
        else -> {  }
    }
}
