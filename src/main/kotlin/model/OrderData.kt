package org.example.model

import org.example.model.menu.SubMenu

// 주문 데이터용 data class를 만든다.
data class OrderData(
    val orderNumber: Int = Int.MIN_VALUE,
    val items: MutableList<SubMenu> = mutableListOf(),
    // val로 하고 copyOf를 쓰는 게 정석인가?!
    var isCancel: Boolean = false
) {
    override fun toString(): String {
        val itemInfos = items.map {
            "- " + it.displayInfo().substring(3)
        }.joinToString("\n")

        val orderState = if (isCancel) "취소" else "정상"

        val sb = StringBuilder()

        sb.append("OrderNumber: $orderNumber\n")
        sb.append("OrderMenu: \n")
        sb.append("$itemInfos\n")
        sb.append("OrderState: $orderState\n")

        return sb.toString()
    }

    fun isEnableOrder() = items.isNotEmpty()
}