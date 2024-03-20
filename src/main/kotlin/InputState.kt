package com.example.kiosk

object inputStateValue {
    var inputState = InputState.MAINMENU
}

enum class InputState {
    MAINMENU, SUBMENU, SHOPPING, ORDER, DONE
}