package com.example.kiosk.model

import com.example.kiosk.model.menu.SubMenu

class ShoppingBasket {
    // 장바구니 데이터용 List 변수를 만든다.
    val items: MutableList<SubMenu> = mutableListOf()

    // 장바구니에 항목을 추가한다.
    fun addItem(item: SubMenu) {
        items.add(item)
    }

    // 장바구니의 목록 출력 - 데이터 반환
    fun printItem(): List<String> = items.map { it.displayInfo() }

    // 주문 완료 시, 장바구니를 초기화 한다.
    fun resetItems() {
        items.clear()
    }
}