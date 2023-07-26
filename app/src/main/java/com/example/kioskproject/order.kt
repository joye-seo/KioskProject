package com.example.kioskproject

import kotlin.system.exitProcess

data class MenuItem(
    var id: Int,            // 메뉴 입력 번호
    var name: String,       // 메뉴 이름들
    var price: Int         // 가격
)

fun main() {
    val first = Order()
    first.firstMenu()
}

class Order() {
    val menulist = MenuList()

    // 첫 메뉴화면
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

    // 메인메뉴 화면
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
                    menulist.menuMap[input]
                    menulist.menuSelection(input)
                }
                0 -> {
                    System.exit(0)
                }
                else -> {
                    println("올바르지 않은 번호입니다. 다시 입력해주세요.\n")
                }
            }
        }
    }
}

open class MenuList() {
    val cartItems = mutableListOf<MenuItem>()
    val menuMap = mapOf(
        1 to listOf(
            MenuItem(1, "에스프레소", 3000),
            MenuItem(2, "아메리카노(HOT)", 3000),
            MenuItem(3, "아메리카노(ICE)", 3500),
            MenuItem(4, "카페라떼(HOT)", 4000),
            MenuItem(5, "카페라뗴(ICE)", 4500),
            MenuItem(6, "카푸치노(HOT)", 4000),
            MenuItem(7, "카푸치노(ICE)", 4500),
        ),
        2 to listOf(
            MenuItem(1, "초코라떼(HOT)", 4000),
            MenuItem(2, "초코라떼(ICE)", 4500),
            MenuItem(3, "그린티라떼(HOT)", 4000),
            MenuItem(4, "그린티라떼(ICE)", 4500),
            MenuItem(5, "고구마라떼(HOT)", 4500),
            MenuItem(6, "고구마라떼(ICE)", 5000),
        ),
        3 to listOf(
            MenuItem(1, "레몬에이드", 5000),
            MenuItem(2, "청포도에이드", 5000),
            MenuItem(3, "딸기에이드", 5000),
            MenuItem(4, "블루베리에이드", 5000)
        ),
        4 to listOf(
            MenuItem(1, "요거트스무디", 5500),
            MenuItem(2, "딸기스무디", 5500),
            MenuItem(3, "망고스무디", 5500),
            MenuItem(4, "블루베리스무디", 6000)
        ),
        5 to listOf(
            MenuItem(1, "페퍼민트(HOT)", 5500),
            MenuItem(2, "페퍼민트(ICE)", 6000),
            MenuItem(3, "캐모마일(HOT)", 5500),
            MenuItem(4, "캐모마일(ICE)", 6000),
            MenuItem(5, "녹차(HOT)", 5500),
            MenuItem(6, "녹차(ICE)", 6000),
        ),
        6 to listOf(
            MenuItem(1, "허니브레드", 8000),
            MenuItem(2, "치즈케이크", 8500),
            MenuItem(3, "딸기케이크", 8500),
            MenuItem(4, "당근케이크", 8000)
        )
    )

    fun menuSelection(menuNumber: Int?) {
        outer@while (true) {
            val menuSelection = menuMap[menuNumber] ?: return

            menuSelection.forEach { (number, description) ->
                if (number != 0) {
                    println("$number. $description")
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
                } else if (menuMap[menuNumber]?.any { it.id == itemNum } == true) {
                    val menuItem = menuMap[menuNumber]!!.find { it.id == itemNum }
                    if (menuItem != null) {
                        cartItems.add(menuItem)
                        selectname.add(menuItem.name)
                    }
                } else {
                    println("${item} 번호는 잘못 입력하셨습니다. 다시 입력해주세요.\n")
                    menuSelection(menuNumber)
                    return
                }
            }
            // 장바구니 내용 출력
            println("장바구니 내용")
            for(item in cartItems)
            {
                println("${item.name} ${item.price}")
            }

            while(true)
            {
                println("----------------------------------------")
                println("1. 추가 주문")
                println("2. 결 제")
                println("3. 결제 취소")
                println("----------------------------------------")

                val totalPrice = cartItems.sumBy { it.price }
                val selectedName = cartItems.map{it.name}
                val selectedMutableList = selectedName.joinToString(", ")
                val choice = readLine()?.toIntOrNull()

                when (choice) {
                    1 -> {
                        break@outer
                    }
                    2 -> {
                        println("\n선택한 항목")
                        println("$selectedMutableList")
                        println("결제 금액 : $totalPrice 원\n")
                        println("----------------------------------------\n")
                        println("결제 완료! 감사합니다.")
                        System.exit(0)
                    }
                    3 -> {
                        println("----------------------------------------")
                        println("주문 취소")
                        println("----------------------------------------\n")
                        cartItems.clear()
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

