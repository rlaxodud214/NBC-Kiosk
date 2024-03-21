package org.example.model.data

data class UserBalance(var money: Double) {
    override fun toString() = "$money$"
}