package com.example.kioskproject

import com.example.kioskproject.data.Item
import com.example.kioskproject.data.Menu
import kotlin.system.exitProcess

class UseCafe() {
    fun mainMenu() {

        while (true) {

            val menuList = mutableListOf(
                Menu("Coffee"),
                Menu("Non-Coffee"),
                Menu("Ade"),
                Menu("Smoothie"),
                Menu("Tea"),
                Menu("Dessert"),
                Menu("장바구니"),
                Menu("프로그램 종료"),
            )
            println("\n아래 메뉴판을 보시고 메뉴를 골라 입력해주세요")
            menuList.forEachIndexed { index, menu ->
                println("${index + 1} ${menu.name}")
            }

            val read = readLine()

            if (read?.let { isNumericToX(it) } == true) {

                when (read) {
                    "1" -> {
                        val coffeeList = mutableListOf(
                            Item("에스프레소", 3000),
                            Item("아메리카노(Hot)", 3000),
                            Item("아메리카노(Ice)", 3500),
                            Item("카페라떼(Hot)", 4000),
                            Item("카페라떼(Ice)", 4500),
                            Item("카푸치노(Hot)", 4000),
                            Item("카푸치노(Ice)", 4500),
                        )
                        cafeList(coffeeList)
                    }

                    "2" -> {
                        val nonCoffeeList = mutableListOf(
                            Item("초코라떼(Hot)", 4000),
                            Item("초코라떼(Ice)", 4500),
                            Item("그린티라떼(Hot)", 4000),
                            Item("그린티라떼(Ice)", 4500),
                            Item("고구마라떼(Hot)", 4500),
                            Item("고구마라떼(Ice)", 5000)
                        )
                        cafeList(nonCoffeeList)
                    }

                    "3" -> {
                        val adeList = mutableListOf(
                            Item("레몬에이드", 5000),
                            Item("자몽에이드", 5000),
                            Item("딸기에이드", 5000),
                            Item("블루베리에이드", 5500)
                        )
                       cafeList(adeList)
                    }

                    "4" -> {
                        val smoothieList = mutableListOf(
                            Item("요거트스무디", 5500),
                            Item("딸기스무디", 5500),
                            Item("망고스무디", 5500),
                            Item("블루베리스무디", 6000)
                        )
                        cafeList(smoothieList)
                    }

                    "5" -> {
                        val teaList = mutableListOf(
                            Item("페퍼민트(Hot)", 5500),
                            Item("페퍼민트(Ice)", 5500),
                            Item("캐모마일(Hot)", 5500),
                            Item("캐모마일(Ice)", 6000),
                            Item("녹차(Hot)", 5500),
                            Item("녹차(Ice)", 6000)
                        )
                        cafeList(teaList)
                    }

                    "6" -> {
                        val dessertList = mutableListOf(
                            Item("허니브레드", 8000),
                            Item("치즈케이크", 8500),
                            Item("딸기케이크", 8500),
                            Item("당근케이크", 8000)
                        )
                        cafeList(dessertList)
                    }

                    "7" -> ShoppingCart().cart()

                    "8" -> exitProcess(0)

                    else -> println(
                        "올바르지 않은 번호입니다. 다시 입력해주세요.\n"
                                + "----------------------------------\n"
                    )
                }
            }


        }
    }
}

fun cafeList(list: MutableList<Item>) {

    while (true) {
        list.forEachIndexed { index, item ->
            println("${index + 1} ${item.name}, ${item.charge}원")
        }
        val back = list.size + 1
        println("${back}. 뒤로가기")
        val num = readLine()
        if (num?.let { isNumericToX(it) } == true) {

            if (num.toInt() == back) {
                UseCafe().mainMenu()
                break
            } else if (num.toInt() in 1 until back) {
                detailMenu = list[num.toInt().minus(1)].name
                totalMenu.add(detailMenu)
                totalCharge += list[num.toInt().minus(1)].charge

                println("\n$detailMenu 를 장바구니에 넣었습니다\n")
            } else {
                println(
                    "올바르지 않은 번호입니다. 다시 입력해주세요.\n"
                            + "----------------------------------\n"
                )
            }
        }
    }
}