package com.example.kiosk.view

import com.example.kiosk.model.menu.Menu

class OutputView {
    fun printInputInfo() {
        println("[Hello] SHAKESHACK BURGER 에 오신걸 환영합니다.")
        println("[Info] 아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
    }

    fun printMenuList(type: String, menuList: List<Menu>, post: String? = null) {
        println("\n[ $type MENU ]")

        menuList.forEach {
            println(it.displayInfo())
        }

        post?.let { println("$post\n") }
    }
}