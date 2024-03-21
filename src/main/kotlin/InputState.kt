package org.example

object inputStateValue {
    var inputState = InputState.MAINMENU
}

enum class InputState {
    MAINMENU, SUBMENU, SHOPPING, ORDER, DONE
}