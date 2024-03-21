package org.example.config

import org.example.configData.SUB_MENU_START_NUMBER
import org.example.model.menu.SubMenu

class SubMenuData() {
    val menuPromptList: List<String> = listOf(
        "====indexing====",
        "Burgers",
        "Pizza",
        "Drink",
        "Beer",
    )

    val subMenuList: List<List<SubMenu>> = listOf(
        listOf(
            SubMenu(SUB_MENU_START_NUMBER + 0, "Burger1", 6.9, "Burger_Info1"),
            SubMenu(SUB_MENU_START_NUMBER + 1, "Burger2", 8.9, "Burger_Info2"),
            SubMenu(SUB_MENU_START_NUMBER + 2, "Burger3", 9.4, "Burger_Info3"),
            SubMenu(SUB_MENU_START_NUMBER + 3, "Burger4", 6.9, "Burger_Info4"),
            SubMenu(SUB_MENU_START_NUMBER + 4, "Burger5", 5.4, "Burger_Info5"),
        ),
        listOf(
            SubMenu(SUB_MENU_START_NUMBER + 0, "Pizza1", 16.9, "Pizza_Info1"),
            SubMenu(SUB_MENU_START_NUMBER + 1, "Pizza2", 18.9, "Pizza_Info2"),
            SubMenu(SUB_MENU_START_NUMBER + 2, "Pizza3", 19.4, "Pizza_Info3"),
            SubMenu(SUB_MENU_START_NUMBER + 3, "Pizza4", 16.9, "Pizza_Info4"),
            SubMenu(SUB_MENU_START_NUMBER + 4, "Pizza5", 15.4, "Pizza_Info5"),
        ),
        listOf(
            SubMenu(SUB_MENU_START_NUMBER + 0, "Ice1", 3.9, "Ice_Info1"),
            SubMenu(SUB_MENU_START_NUMBER + 1, "Ice2", 4.9, "Ice_Info2"),
            SubMenu(SUB_MENU_START_NUMBER + 2, "Ice3", 3.4, "Ice_Info3"),
            SubMenu(SUB_MENU_START_NUMBER + 3, "Ice4", 3.8, "Ice_Info4"),
            SubMenu(SUB_MENU_START_NUMBER + 4, "Ice5", 5.4, "Ice_Info5"),
        ),
        listOf(
            SubMenu(SUB_MENU_START_NUMBER + 0, "Beer1", 4.9, "Beer_Info1"),
            SubMenu(SUB_MENU_START_NUMBER + 1, "Beer2", 5.9, "Beer_Info2"),
            SubMenu(SUB_MENU_START_NUMBER + 2, "Beer3", 4.4, "Beer_Info3"),
            SubMenu(SUB_MENU_START_NUMBER + 3, "Beer4", 2.8, "Beer_Info4"),
            SubMenu(SUB_MENU_START_NUMBER + 4, "Beer5", 3.4, "Beer_Info5"),
        )
    )
}