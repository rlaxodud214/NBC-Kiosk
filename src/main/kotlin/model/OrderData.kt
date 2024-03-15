package com.example.kiosk.model

import com.example.kiosk.model.menu.SubMenu

// 주문 데이터용 data class를 만든다.
data class OrderData(
    val orderNumber: Int = Int.MIN_VALUE,
    val items: MutableList<SubMenu> = mutableListOf(),
    // val로 하고 copyOf를 쓰는 게 정석인가?!
    var isCancel: Boolean = false
) {
    override fun toString(): String {
        return """
            OrderNumber: $orderNumber
            OrderMenu: ${
            items.map {
                it.displayInfo().substring(3)
            }.apply { 
                println(this)
            }.joinToString { "\n" }
        }
            OrderState: ${
            if (isCancel) "취소" else "정상"
        }        
        """.trimIndent()
    }
}