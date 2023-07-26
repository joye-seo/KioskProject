package com.example.kioskproject

import com.example.kioskproject.menu.Ade
import com.example.kioskproject.menu.Coffee
import com.example.kioskproject.menu.Dessert
import com.example.kioskproject.menu.NonCoffee
import com.example.kioskproject.menu.Smoothie
import com.example.kioskproject.menu.Tea
import kotlin.system.exitProcess

class Menu() {
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
                        "7. 계산하기\n" +
                        "8. 프로그램 종료"
            )

            try {
                when (readLine()?.toInt()) {

                    1 -> {
                        Coffee().displayInfo()
                        break
                    }

                    2 -> {
                        NonCoffee().displayInfo()
                        break
                    }

                    3 -> {
                        Ade().displayInfo()
                        break
                    }

                    4 -> {
                        Smoothie().displayInfo()
                        break
                    }

                    5 -> {
                        Tea().displayInfo()
                        break
                    }

                    6 -> {
                        Dessert().displayInfo()
                        break
                    }

                    7 -> {
                        Basket().payment()
                        break
                    }

                    8 -> {
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
