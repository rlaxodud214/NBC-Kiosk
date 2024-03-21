package org.example.model

import org.example.model.menu.SubMenu

// 기존에 ShoppingBasket은 class였고, 객체를 companion object에 두고 사용함
// companion object를 없애자고, object로 만들어버림 아무것도 해결되지 않았다,,
// TODO: 다시 클래스로 변경하고, 메인 컨트롤러에서 객체 생성 후 전역 접근 안되도록 수정할 것
object ShoppingBasket {
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

    // 장바구니 옵션 활성화 유무
    fun isEnableShopping() = items.isNotEmpty()
}