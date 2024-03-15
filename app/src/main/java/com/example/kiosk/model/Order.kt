package com.example.kiosk.model

import com.example.kiosk.model.menu.Menu

// Food와 프로퍼티 형식이 같다. 상속을 받아도 되는 걸까?
// 하지만, FoodMenu와 OrderMenu라는 의미의 차이가 있음
// 상속을 받으려면, Menu class를 Menu로 명명하는 게 맞을 것 같다.
// 상속을 받으면, outputView의 메소드 3개를 하나로 합칠 수 있음
class Order(
    override val number: Int,
    override val name: String,
    override val description: String,
) : Menu(number, name, description) {
    override fun displayInfo(): String {
        val nameWithSpace = name.padEnd(10, ' ')

        return "$number. $nameWithSpace  |  $description"
    }
}