package com.example.kioskproject

import kotlin.system.exitProcess

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
                        Menu().mainMenuList()
                        break
                    }

                    2 -> {
                        method = "포장하기"
                        Menu().mainMenuList()
                        break
                    }

                    3 -> {
                        println("프로그램 종료")
                        exitProcess(0)
                    }

                    else -> println(
                        "올바르지 않은 번호입니다. 다시 입력해주세요.\n"
                                + "----------------------------------\n"
                    )

                }
            } catch (e: java.lang.NumberFormatException) {
                println(
                    "메뉴 주문은 숫자만 입력할 수 있습니다.\n"
                            + "----------------------------------\n"
                )
            }
        }
    }
}

