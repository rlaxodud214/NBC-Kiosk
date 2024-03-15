package com.example.kiosk.model

import com.example.kiosk.model.menu.SubMenu

class ShoppingBasket {
    // 장바구니 데이터용 List 변수를 만든다.
    var items: MutableList<SubMenu> = mutableListOf()

    // 장바구니에 항목을 추가한다.
    fun addItem(item: SubMenu) {
        items.add(item)
    }

    // 장바구니 목록의 출력 데이터를 반환한다.
    fun getItemInfo(): List<String> = items.map {
        it.displayInfo()
    }

    // 장바구니에 담긴 메뉴의 총 가격을 반환한다.
    fun getTotalPrice() = items.map {
        it.price * 10
    }.sum() / 10.0

    // 주문 완료 시, 장바구니를 초기화 한다.
    fun resetItems() {
        items.clear()
    }
}