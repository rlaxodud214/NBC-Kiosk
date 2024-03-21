package org.example

import org.example.controller.MainController
import org.example.model.data.UserBalance
import org.example.view.OutputView
import kotlin.math.roundToInt
import kotlin.random.Random

fun main() {
    val mainController = MainController()
    OutputView.printInputInfo()

    val userBalance = UserBalance(
        Random.nextDouble(200.0).roundToInt() / 10.0 + 10
    )
    println("현재 잔액: $userBalance")

    while (MainController.inputState != InputState.DONE) {
        try {
            mainController.run(userBalance)
        } catch (e: Exception) {
            when (e) {
                is NumberFormatException, is IllegalStateException -> {
                    OutputView.printErrorMessage(e)
                }
            }
        }
    }
}

