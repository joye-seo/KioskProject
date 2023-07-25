package com.example.kioskproject


fun main() {
    println("안녕하세요? 투썸플레이스입니다.\n")
    Order().startOrder()
}

lateinit var method: String
lateinit var detailMenu: String
var totalCharge: Int = 0

class Order {
    fun startOrder() {
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

                    else -> println(
                        "올바르지 않은 번호입니다. 다시 입력해주세요.\n"
                                + "----------------------------------\n"
                    )
                }
            } catch (e: java.lang.NumberFormatException) {
                println("메뉴 주문은 숫자만 입력할 수 있습니다. \n----------------------------------\n")
            }
        }

    }
}


