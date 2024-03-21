package org.example

import org.example.controller.MainController
import org.example.model.Balance
import org.example.model.UserSelectNumbers
import org.example.view.InputView
import org.example.view.OutputView
import kotlin.math.roundToInt
import kotlin.random.Random

fun main() {
    var userSelectNumbers = UserSelectNumbers()

    val mainController = MainController(userSelectNumbers)
    OutputView.printInputInfo()

    val userBalance = Balance(
        Random.nextDouble(200.0).roundToInt() / 10.0 + 10
    )
    println("현재 잔액: $userBalance")

    while (MainController.inputState != InputState.DONE) {
        try {
            mainController.run(userBalance)

        } catch (e: NumberFormatException) {
            printErrorMessage(e)
            initState(userSelectNumbers)
        } catch (e: IllegalStateException) {
            printErrorMessage(e)
        }
    }
}

fun printErrorMessage(e: Exception) {
    val errorMessage = e.message?.let { it } ?: "[Fix] 원인 모를 오류 발생"
    println("$errorMessage \n")
}

fun initState(userSelectNumbers: UserSelectNumbers) {
    when (MainController.inputState) {
        InputState.SUBMENU -> userSelectNumbers.subNumber = Int.MIN_VALUE
        else -> {}
    }
}
