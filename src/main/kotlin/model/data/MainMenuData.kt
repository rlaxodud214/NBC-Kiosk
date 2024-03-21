package org.example.config

import org.example.configData.MAIN_MENU_START_NUMBER
import org.example.model.menu.MainMenu
import org.example.model.menu.OrderMenu

class MainMenuData() {
    val mainMenuList = listOf(
        MainMenu(MAIN_MENU_START_NUMBER + 0, "Burgers", "앵거스 비프 통살을 다져만든 버거"),
        MainMenu(MAIN_MENU_START_NUMBER + 1, "Pizza", "신선한 토핑이 올라간 피자"),
        MainMenu(MAIN_MENU_START_NUMBER + 2, "Drinks", "매장에서 직접 만드는 음료"),
        MainMenu(MAIN_MENU_START_NUMBER + 3, "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"),
    )

    val orderList = listOf(
        OrderMenu(getLastMainMenuNumber() + 1, "OrderMenu", "장바구니를 확인 후 주문합니다."),
        OrderMenu(getLastMainMenuNumber() + 2, "Cancel", "진행중인 주문을 취소합니다.")
    )
    fun getLastMainMenuNumber() = mainMenuList.size
}