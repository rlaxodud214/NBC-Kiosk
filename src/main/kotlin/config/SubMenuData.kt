package org.example.config

import org.example.model.menu.SubMenu

class SubMenuData(
    val menuPromptList: List<String> = listOf(
        "====indexing====",
        "Burgers",
        "Pizza",
        "Drink",
        "Beer",
    ),
    val subMenuList: List<List<SubMenu>> = listOf(
        listOf(
            SubMenu(1, "Burger1", 6.9, "Burger_Info1"),
            SubMenu(2, "Burger2", 8.9, "Burger_Info2"),
            SubMenu(3, "Burger3", 9.4, "Burger_Info3"),
            SubMenu(4, "Burger4", 6.9, "Burger_Info4"),
            SubMenu(5, "Burger5", 5.4, "Burger_Info5"),
        ),
        listOf(
            SubMenu(1, "Pizza1", 16.9, "Pizza_Info1"),
            SubMenu(2, "Pizza2", 18.9, "Pizza_Info2"),
            SubMenu(3, "Pizza3", 19.4, "Pizza_Info3"),
            SubMenu(4, "Pizza4", 16.9, "Pizza_Info4"),
            SubMenu(5, "Pizza5", 15.4, "Pizza_Info5"),
        ),
        listOf(
            SubMenu(1, "Ice1", 3.9, "Ice_Info1"),
            SubMenu(2, "Ice2", 4.9, "Ice_Info2"),
            SubMenu(3, "Ice3", 3.4, "Ice_Info3"),
            SubMenu(4, "Ice4", 3.8, "Ice_Info4"),
            SubMenu(5, "Ice5", 5.4, "Ice_Info5"),
        ),
        listOf(
            SubMenu(1, "Beer1", 4.9, "Beer_Info1"),
            SubMenu(2, "Beer2", 5.9, "Beer_Info2"),
            SubMenu(3, "Beer3", 4.4, "Beer_Info3"),
            SubMenu(4, "Beer4", 2.8, "Beer_Info4"),
            SubMenu(5, "Beer5", 3.4, "Beer_Info5"),
        ),
    )
)