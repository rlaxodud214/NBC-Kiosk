package com.example.kiosk.model

data class Balance(var money: Double) {
    override fun toString() = "$money$"
}