package org.example.model.data

import org.example.configData.DECIMAL_PRECISION_FACTOR
import org.example.model.menu.SubMenu

class ShoppingBasketData {
    private val items: MutableList<SubMenu> = mutableListOf()

    fun addItem(item: SubMenu) {
        items.add(item)
    }

    fun getItem() = items

    fun getItemInfo(): List<String> = items.map {
        it.displayInfo()
    }

    fun getTotalPrice() = items.map {
        it.price * DECIMAL_PRECISION_FACTOR
    }.sum() / DECIMAL_PRECISION_FACTOR

    fun resetItems() {
        items.clear()
    }
}