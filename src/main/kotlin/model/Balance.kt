package org.example.model

data class Balance(var money: Double) {
    override fun toString() = "$money$"
}