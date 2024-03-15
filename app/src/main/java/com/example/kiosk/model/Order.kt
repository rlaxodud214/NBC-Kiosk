package com.example.kiosk.model

import com.example.kiosk.model.menu.SubMenu

class Order() {
    // 주문 데이터용 List 변수를 만든다.
    var orderNumber: Int = Int.MIN_VALUE
    val items: MutableList<SubMenu> = mutableListOf()

    fun addItem(item: MutableList<SubMenu>) {
        items.add(item)
    }
}