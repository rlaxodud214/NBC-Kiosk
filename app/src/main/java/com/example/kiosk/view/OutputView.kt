package com.example.kiosk.view

import com.example.kiosk.menu.MainMenu

class OutputView {
    fun printMainMenuList(mainMenuList: List<MainMenu>) {
        println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n")

        mainMenuList.forEach {
            println(it.displayInfo())
        }

        println("0. Exit            |  프로그램 종료")
    }

    fun printSubMenuList(inputNumber: Int) {
        val inputPrompt = when(inputNumber) {
            1 -> """
                [ Burgers MENU ]
                1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
                2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
                3. Shroom Burger | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거
                4. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
                5. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
                0. Back          | 뒤로가기 
            """.trimIndent()

            else -> throw Exception("잘못된 번호를 입력했어요 다시 입력해주세요.")
        }

        println("$inputPrompt\n")
    }
}