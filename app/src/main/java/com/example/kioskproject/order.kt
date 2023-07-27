package com.example.kioskproject

import kotlin.system.exitProcess

data class MenuItem(
    var id: Int,            // 메뉴 입력 번호
    var name: String,       // 메뉴 이름들
    var price: Int         // 가격
) {
}

fun main() {
    val order = Order()
    order.firstMenu()
}

// 메뉴 카테고리 리스트
class MenuCategory {
    val Coffee = listOf(
        MenuItem(1, "에스프레소", 3000),
        MenuItem(2, "아메리카노(HOT)", 3000),
        MenuItem(3, "아메리카노(ICE)", 3500),
        MenuItem(4, "카페라떼(HOT)", 4000),
        MenuItem(5, "카페라뗴(ICE)", 4500),
        MenuItem(6, "카푸치노(HOT)", 4000),
        MenuItem(7, "카푸치노(ICE)", 4500),
    )
    val NonCoffee = listOf(
        MenuItem(1, "초코라떼(HOT)", 4000),
        MenuItem(2, "초코라떼(ICE)", 4500),
        MenuItem(3, "그린티라떼(HOT)", 4000),
        MenuItem(4, "그린티라떼(ICE)", 4500),
        MenuItem(5, "고구마라떼(HOT)", 4500),
        MenuItem(6, "고구마라떼(ICE)", 5000),
    )
    val Ade = listOf(
        MenuItem(1, "레몬에이드", 5000),
        MenuItem(2, "청포도에이드", 5000),
        MenuItem(3, "딸기에이드", 5000),
        MenuItem(4, "블루베리에이드", 5000)
    )
    val Smoothie = listOf(
        MenuItem(1, "요거트스무디", 5500),
        MenuItem(2, "딸기스무디", 5500),
        MenuItem(3, "망고스무디", 5500),
        MenuItem(4, "블루베리스무디", 6000)
    )
    val tea = listOf(
        MenuItem(1, "페퍼민트(HOT)", 5500),
        MenuItem(2, "페퍼민트(ICE)", 6000),
        MenuItem(3, "캐모마일(HOT)", 5500),
        MenuItem(4, "캐모마일(ICE)", 6000),
        MenuItem(5, "녹차(HOT)", 5500),
        MenuItem(6, "녹차(ICE)", 6000),
    )
    val dessert = listOf(
        MenuItem(1, "허니브레드", 8000),
        MenuItem(2, "치즈케이크", 8500),
        MenuItem(3, "딸기케이크", 8500),
        MenuItem(4, "당근케이크", 8000)
    )

    // 메뉴 선택 시 서브 메뉴로
    fun subMenuCategory(categoryNumber : Int):List<MenuItem>? {
        return when(categoryNumber) {
            1 -> Coffee
            2 -> NonCoffee
            3 -> Ade
            4 -> Smoothie
            5 -> tea
            6 -> dessert
            else -> null
        }
    }
}

// 결제 클래스
open class OrderSystem() {
    val menuCategory = MenuCategory()
    val cartItem = mutableListOf<MenuItem>()

    // 메뉴 선택 화면 출력
    fun selectMenu(menuNumber:Int) {
        while (true) {
            val menuSelection = menuCategory.subMenuCategory(menuNumber)

            menuSelection?.forEach { (number, description, price : Int) ->
                if (number != 0) {
                    println("$number. $description | $price")
                }
            }
            println("0. 뒤로가기")
            println("\n주문하실 메뉴를 선택하세요 (여러가지일 경우 띄어쓰기로 구분)")

            var selectedItems = readLine()?.split(" ") ?: emptyList()
            val selectedItemChargeList = mutableListOf<Int>()
            val selectname = mutableListOf<String>()

            for (item in selectedItems) {
                val itemNum = item.toIntOrNull()
                if (itemNum == 0) {
                    return
                } else if (menuSelection?.any { it.id == itemNum } == true) {
                    val menuItem = menuSelection.find { it.id == itemNum }
                    if (menuItem != null) {
                        cartItem.add(menuItem)
                        selectname.add(menuItem.name)
                    }
                } else {
                    println("${item} 번호는 잘못 입력하셨습니다. 다시 입력해주세요.\n")
                    selectMenu(menuNumber)
                    return
                }
            }
            println("\n장바구니 내용")
            for (item in cartItem) {
                println("${item.name} ${item.price}")
            }
            println()
        while(true)
        {
            println("----------------------------------------")
            println("1. 추가 주문")
            println("2. 결 제")
            println("3. 결제 취소")
            println("----------------------------------------")

            val totalPrice = cartItem.sumBy { it.price }
            val selectedName = cartItem.map { it.name }
            val selectedMutableList = selectedName.joinToString(", ")
            val choice = readLine()?.toIntOrNull()
            when (choice) {
                1 -> {
                    return
                }
                2 -> {
                    println("\n------------ 영 수 증 -----------------")
                    println("$selectedMutableList")
                    println("결제 금액 : $totalPrice 원")
                    println("----------------------------------------\n")
                    println("결제 완료! 감사합니다.")
                    System.exit(0)
                }
                3 -> {
                    println("----------------------------------------")
                    println("주 문 취 소")
                    println("----------------------------------------\n")
                    cartItem.clear()
                    Order().mainMenu()
                    break
                }
                else -> {
                    println("잘못 입력하셨습니다. 다시 입력해주세요.")
                    continue
                    }
                }
            }
        }
    }
}

// 결제 총괄 진행 클래스
class Order : OrderSystem() {
    // 매장 이용 방법
    fun firstMenu() {
        while (true) {
            println(
                "매장 이용 방법을 선택해주세요\n" +
                        "1. 매장식사\n" +
                        "2. 포장하기\n" +
                        "0. 프로그램종료"
            )
            when (readLine()?.toIntOrNull()) {
                in 1..2 -> {
                    // 메인메뉴로 이동
                    mainMenu()
                    break
                }
                0 -> {
                    println("프로그램 종료")
                    exitProcess(0)
                }
                else -> println("올바르지 않은 번호입니다. 다시 입력해주세요. \n----------------------------------\n")
            }
        }
    }

    // 메인 메뉴 화면
    fun mainMenu() {
        while (true) {
            println("아래 메뉴판 중 메뉴를 골라 번호를 입력하세요.")
            println("1. Coffee")
            println("2. Non-Coffee")
            println("3. Ade")
            println("4. Smoothie")
            println("5. Tea")
            println("6. Dessert")
            println("0. 프로그램 종료")

            var input = readLine()?.toIntOrNull()
            println()
            when(input){
                in 1..6 -> {
                    selectMenu(input!!)
                }
                0 -> {
                    exitProcess(0)
                }
                else -> {
                    println("올바르지 않은 번호입니다. 다시 입력해주세요.\n")
                }
            }
        }
    }

}
