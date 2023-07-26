package com.example.kioskproject

import kotlin.system.exitProcess

data class MenuItem(
    var id: Int,
    var name: String,
    var charge: Int
)

fun main() {
    println("안녕하세요? 투썸플레이스입니다.\n")
    CafeKiosk().start()
}

class CafeKiosk {
    private val menuItems = mapOf(
        1 to listOf(
            MenuItem(1, "에스프레소", 3000),
            MenuItem(2, "아메리카노(Hot)", 3000),
            MenuItem(3, "아메리카노(Ice)", 3500),
            MenuItem(4, "카페라떼(Hot)", 4000),
            MenuItem(5, "카페라떼(Ice)", 4500),
            MenuItem(6, "카푸치노(Hot)", 4000),
            MenuItem(7, "카푸치노(Ice)", 4500)
        ),
        2 to listOf(
            MenuItem(1, "초코라떼(Hot)", 4000),
            MenuItem(2, "초코라떼(Ice)", 4500),
            MenuItem(3, "그린티라떼(Hot)", 4000),
            MenuItem(4, "그린티라떼(Ice)", 4500),
            MenuItem(5, "고구마라떼(Hot)", 4500),
            MenuItem(6, "고구마라떼(Ice)", 5000)
        ),
        3 to listOf(
            MenuItem(1, "복숭아에이드(Ice)", 6000),
            MenuItem(2, "레몬셔벗에이드(Ice)", 6500),
            MenuItem(3, "오렌지에이드(Ice)", 5500),
            MenuItem(4, "자몽에이드(Ice)", 5500),
            MenuItem(5, "샤인머스켓에이드(Ice)", 6500),
        ),
        4 to listOf(
            MenuItem(1, "망고스무디(Ice)", 5000),
            MenuItem(2, "요거트프라페(Ice)", 5500),
            MenuItem(2, "밀크쉐이크(Ice)", 5500),
            MenuItem(2, "민트초코프라페(Ice)", 5500),
            MenuItem(2, "요거트스무디(Ice)", 5500),
        ),
        5 to listOf(
            MenuItem(1, "복숭아아이스티(Ice)", 4000),
            MenuItem(2, "레몬아이스티(Ice)", 4000),

        ),
        6 to listOf(
            MenuItem(1, "아이스크림크로플", 6500),
            MenuItem(2, "치즈크로플", 5100),
            MenuItem(2, "스트로베리 초콜릿 생크림", 36000),
            MenuItem(2, "스트로베리 티라미수", 34000),
            MenuItem(2, "딸기그뤼에르치즈무스", 38000),
        ),
        // 나머지 메뉴들도 같은 방식으로 추가
    )

    private val menuCategories = listOf(
        "Coffee", "Non-Coffee", "Ade", "Smoothie", "Tea", "Dessert"
    )

    private var method: String = ""
    private var detailMenu: String = ""
    private var orderList: MutableMap<MenuItem, Int> = mutableMapOf()
    private var totalCharge: Int = 0

    fun start() {
        while (true) {
            println(
                "주문을 하시려면 1번을 눌러주세요.\n" +
                        "1. 주문하기\n" +
                        "2. 프로그램 종료."
            )

            when (readLine()?.toIntOrNull()) {
                1 -> {
                    useCafeMethod()
                    break
                }
                2 -> {
                    println("프로그램 종료")
                    exitProcess(0)
                }
                else -> println("올바르지 않은 번호입니다. 다시 입력해주세요.")
            }
        }
    }

    private fun useCafeMethod() {
        while (true) {
            println(
                "매장 이용 방법을 선택해주세요\n" +
                        "1. 매장식사\n" +
                        "2. 포장하기\n" +
                        "3. 프로그램 종료"
            )

            when (readLine()?.toIntOrNull()) {
                1 -> {
                    method = "매장식사"
                    showMainMenu()
                    break
                }
                2 -> {
                    method = "포장하기"
                    showMainMenu()
                    break
                }
                3 -> {
                    println("프로그램 종료")
                    exitProcess(0)
                }
                else -> println("올바르지 않은 번호입니다. 다시 입력해주세요.")
            }
        }
    }

    private fun showMainMenu() {
        while (true) {
            println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요")

            for ((index, category) in menuCategories.withIndex()) {
                println("${index + 1}. $category")
            }

            val categoryIndex = readLine()?.toIntOrNull() ?: 0
            if (categoryIndex in 1..menuCategories.size) {
                val menuCategory = menuCategories[categoryIndex - 1]
                val menuList = menuItems[categoryIndex]
                showMenuList(menuCategory, menuList)
                break
            } else {
                println("올바르지 않은 번호입니다. 다시 입력해주세요.")
            }
        }
    }

    private fun showMenuList(category: String, menuList: List<MenuItem>?) {
        if (menuList == null) {
            println("메뉴가 없습니다.")
            return
        }

        while (true) {
            println("----- $category 메뉴 -----")

            for ((index, menuItem) in menuList.withIndex()) {
                println("${index + 1}. ${menuItem.name} - ${menuItem.charge}원")
            }

            println("--------------------")
            println("주문을 원하는 메뉴의 번호를 입력하세요. (0 입력 시 종료)")

            val menuNumber = readLine()?.toIntOrNull() ?: 0
            if (menuNumber == 0) {
                showOrderSummary()
                break
            } else if (menuNumber in 1..menuList.size) {
                val selectedMenu = menuList[menuNumber - 1]
                detailMenu = selectedMenu.name
                totalCharge += selectedMenu.charge

                // 주문한 메뉴추가
                orderList[selectedMenu] = (orderList[selectedMenu] ?: 0) + 1
            } else {
                println("올바르지 않은 번호입니다. 다시 입력해주세요.")
            }
        }
    }


    private fun showOrderSummary() {
        println("----------------------------------")
        println("주문 내역")
        println("이용 방법: $method")

        if (orderList.isEmpty()) {
            println("주문한 메뉴가 없습니다.")
        } else {
            for ((menuItem, count) in orderList) {
                println("${menuItem.name} - $count 개")
            }
            println("총 결제 금액: $totalCharge 원")
        }

        println("----------------------------------")

        orderList.clear()
        totalCharge = 0
    }

}
