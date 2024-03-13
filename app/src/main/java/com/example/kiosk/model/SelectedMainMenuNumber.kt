package com.example.kiosk.model

data class SelectedMenuNumber(
    var mainNumber: Int = Int.MIN_VALUE,
    var subNumber: Int = Int.MIN_VALUE
) {
    init {
        /*
        mainNumber와 subNumber는 따로 초기화를 할 텐데 init에서 한 번에 검증하기가 까다롭다.
        1. 선택한 메인 메뉴 번호와 서브 메뉴 번호를 서로 다른 data class로 만들고
           각각 init에서 validate를 호출한다?
        2. var을 쓰는 것 부터가 data class의 의미가 모호해지는 면이 있으니 object로 만들까?
           ->
         */
    }
}