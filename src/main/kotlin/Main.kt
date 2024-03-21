package org.example

import org.example.configData.DECIMAL_PRECISION_FACTOR
import org.example.configData.DEFAULT_MONEY
import org.example.configData.MAX_RANDOM_MONEY
import org.example.controller.MainController
import org.example.model.data.UserBalance
import org.example.view.OutputView
import kotlin.math.roundToInt
import kotlin.random.Random

fun main() {
    var inputState = InputState.MAINMENU
    val mainController = MainController()

    OutputView.printInputInfo()

    val randomMoney = Random.nextDouble(MAX_RANDOM_MONEY * DECIMAL_PRECISION_FACTOR)
    val userBalance = UserBalance(
        randomMoney.roundToInt() / DECIMAL_PRECISION_FACTOR + DEFAULT_MONEY
    )
    println("현재 잔액: $userBalance")

    while (inputState != InputState.DONE) {
        try {
            inputState = mainController.run(inputState, userBalance)
        } catch (e: NumberFormatException) {
            OutputView.printErrorMessage(e)
        } catch (e: IllegalStateException) {
            OutputView.printErrorMessage(e)
        }
    }
}