package com.example.kioskproject

import kotlin.system.exitProcess

data class MenuItem(
    var id: Int,
    var name: String,
    var charge: Int
)

fun main() {

    println("안녕하세요? 투썸플레이스입니다.\n")
    Order().firstOrder()

}

lateinit var method: String
lateinit var detailMenu: String
var totalCharge: Int = 0

class Order {

    fun firstOrder() {

        while (true) {
            try {
                println(
                    "주문을 하시려면 1번을 눌러주세요.\n" +
                            "1. 주문하기\n" +
                            "2. 프로그램 종료."
                )

                when (readLine()?.toInt()) {
                    1 -> {
                        UseCafe().useMethodChoice()
                        break
                    }

                    2 -> {
                        println("프로그램 종료")
                        System.exit(0)
                    }

                    else -> println("올바르지 않은 번호입니다. 다시 입력해주세요. \n----------------------------------\n")

                }
            } catch (e: java.lang.NumberFormatException) {
                println("메뉴 주문은 숫자만 입력할 수 있습니다. \n----------------------------------\n")
            }
        }

    }
}

class UseCafe() {
    fun useMethodChoice() {

        while (true) {

            println(
                "매장 이용 방법을 선택해주세요\n" +
                        "1. 매장식사\n" +
                        "2. 포장하기\n" +
                        "3. 프로그램종료"
            )

            try {

                when (readLine()?.toInt()) {
                    1 -> {
                        method = "매장식사"
                        MainMenu().mainMenuList()
                        break
                    }

                    2 -> {
                        method = "포장하기"
                        MainMenu().mainMenuList()
                        break
                    }

                    3 -> {
                        println("프로그램 종료")
                        exitProcess(0)
                    }

                    else -> println("올바르지 않은 번호입니다. 다시 입력해주세요. \n----------------------------------\n")

                }
            } catch (e: java.lang.NumberFormatException) {
                println("메뉴 주문은 숫자만 입력할 수 있습니다. \n----------------------------------\n")
            }
        }
    }
}

class MainMenu() {

    fun mainMenuList() {
        while (true) {

            println(
                "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요\n" +
                        "1. Coffee\n" +
                        "2. Non-Coffee\n" +
                        "3. Ade\n" +
                        "4. Smoothie\n" +
                        "5. Tea\n" +
                        "6. Dessert\n" +
                        "7. 프로그램 종료"
            )

            try {

                when (readLine()?.toInt()) {
                    1 -> {
                        val list = listOf(
                            MenuItem(1, "에스프레소", 3000), MenuItem(2, "아메리카노(Hot)", 3000),
                            MenuItem(3, "아메리카노(Ice)", 3500), MenuItem(4, "카페라떼(Hot)", 4000),
                            MenuItem(5, "카페라떼(Ice)", 4500), MenuItem(6, "카푸치노(Hot)", 4000),
                            MenuItem(7, "카푸치노(Ice)", 4500)
                        )
                        for ((a, b, c) in list) {
                            println("$a. $b $c")
                        }
                        try {
                            while (true) {
                                val num = readLine()?.toInt()
                                detailMenu = list[num?.minus(1)!!].name //코드 수정해보기
                                totalCharge = list[num - 1].charge //코드 수정해보기
                                break
                            }

                        } catch (e: java.lang.NumberFormatException) {
                            println("메뉴 주문은 숫자만 입력할 수 있습니다. \n----------------------------------\n")
                        }
                        DetailMenu().numClick()
                        break
                    }

                    2 -> {
                        val list = listOf(
                            MenuItem(1, "초코라떼(Hot)", 4000), MenuItem(2, "초코라떼(Ice)", 4500),
                            MenuItem(3, "그린티라떼(Hot)", 4000), MenuItem(4, "그린티라떼(Ice)", 4500),
                            MenuItem(5, "고구마라떼(Hot)", 4500), MenuItem(6, "고구마라떼(Ice)", 5000)
                        )
                        for ((a, b, c) in list) {
                            println("$a. $b $c")
                        }
                        try {
                            while (true) {
                                val num = readLine()?.toInt()
                                detailMenu = list[num?.minus(1)!!].name //코드 수정해보기
                                totalCharge = list[num - 1].charge //코드 수정해보기
                                break
                            }

                        } catch (e: java.lang.NumberFormatException) {
                            println("메뉴 주문은 숫자만 입력할 수 있습니다. \n----------------------------------\n")
                        }
                        DetailMenu().numClick()
                        break
                    }

                    3 -> {
                        val list = listOf(
                            MenuItem(1, "레몬에이드", 5000), MenuItem(2, "레몬에이드", 5000),
                            MenuItem(3, "딸기에이드", 5000), MenuItem(4, "블루베리에이드", 5500)
                        )
                        for ((a, b, c) in list) {
                            println("$a. $b $c")
                        }
                        try {
                            while (true) {
                                val num = readLine()?.toInt()
                                detailMenu = list[num?.minus(1)!!].name //코드 수정해보기
                                totalCharge = list[num - 1].charge //코드 수정해보기
                                break
                            }

                        } catch (e: java.lang.NumberFormatException) {
                            println("메뉴 주문은 숫자만 입력할 수 있습니다. \n----------------------------------\n")
                        }
                        DetailMenu().numClick()
                        break
                    }

                    4 -> {
                        val list = listOf(
                            MenuItem(1, "요거트스무디", 5500), MenuItem(2, "딸기스무디", 5500),
                            MenuItem(3, "망고스무디", 5500), MenuItem(4, "블루베리스무디", 6000)
                        )
                        for ((a, b, c) in list) {
                            println("$a. $b $c")
                        }
                        try {
                            while (true) {
                                val num = readLine()?.toInt()
                                detailMenu = list[num?.minus(1)!!].name //코드 수정해보기
                                totalCharge = list[num - 1].charge //코드 수정해보기
                                break
                            }

                        } catch (e: java.lang.NumberFormatException) {
                            println("메뉴 주문은 숫자만 입력할 수 있습니다. \n----------------------------------\n")
                        }
                        DetailMenu().numClick()
                        break
                    }

                    5 -> {
                        val list = listOf(
                            MenuItem(1, "페퍼민트(Hot)", 5500), MenuItem(2, "페퍼민트(Ice)", 5500),
                            MenuItem(3, "캐모마일(Hot)", 5500), MenuItem(4, "캐모마일(Ice)", 6000),
                            MenuItem(5, "녹차(Hot)", 5500), MenuItem(6, "녹차(Ice)", 6000)
                        )
                        for ((a, b, c) in list) {
                            println("$a. $b $c")
                        }
                        try {
                            while (true) {
                                val num = readLine()?.toInt()
                                detailMenu = list[num?.minus(1)!!].name //코드 수정해보기
                                totalCharge = list[num - 1].charge //코드 수정해보기
                                break
                            }

                        } catch (e: java.lang.NumberFormatException) {
                            println("메뉴 주문은 숫자만 입력할 수 있습니다. \n----------------------------------\n")
                        }
                        DetailMenu().numClick()
                        break
                    }

                    6 -> {
                        val list = listOf(
                            MenuItem(1, "허니브레드", 8000), MenuItem(2, "치즈케이크", 8500),
                            MenuItem(3, "딸기케이크", 8500), MenuItem(4, "당근케이크", 8000)
                        )

                        for ((a, b, c) in list) {
                            println("$a. $b $c")
                        }

                        try {
                            while (true) {
                                val num = readLine()?.toInt()
                                detailMenu = list[num?.minus(1)!!].name //코드 수정해보기
                                totalCharge = list[num - 1].charge //코드 수정해보기
                                break
                            }

                        } catch (e: java.lang.NumberFormatException) {
                            println("메뉴 주문은 숫자만 입력할 수 있습니다. \n----------------------------------\n")
                        }

                        DetailMenu().numClick()
                        break
                    }

                    else -> println("올바르지 않은 번호입니다. 다시 입력해주세요. \n----------------------------------\n")
                }
            } catch (e: java.lang.NumberFormatException) {
                println("메뉴 주문은 숫자만 입력할 수 있습니다. \n----------------------------------\n")
            }


        }
    }
}

class DetailMenu() {
    fun numClick() {
        println(
            "----------------------------------\n" +
                    "주문 내역 입니다.\n" +
                    "$method\n" +
                    "$detailMenu\n" +
                    "$totalCharge"
        )
    }
}