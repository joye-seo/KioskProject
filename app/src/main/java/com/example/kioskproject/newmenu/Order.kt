package com.example.kioskproject.newmenu

import kotlin.system.exitProcess

class Order : OrderSystem() {
    fun first() {
        while (true) {
            println("매장 이용방법을 선택해주세요")
            println("1. 매장식사")
            println("2. 포장하기")
            println("0. 프로그램 종료")

            when (readLine()?.toIntOrNull()) {
                in 1..2 -> {
                    mainmenu()
                    break
                }

                0 -> {
                    println("프로그램 종료")
                    exitProcess(0)
                }

                else -> println("올바르지 않은 번호입니다. 다시 입력 해주세요.")
            }
        }
    }

    fun mainmenu() {
        while (true) {
            println("아래 메뉴판 중 메뉴를 골라 번호를 입력하세요.")
            println("1. Coffee")
            println("2. Non-Coffee")
            println("3. Ade")
            println("4. Smoothie")
            println("5. Tea")
            println("6. Dessert")
            println("0. 뒤로 가기")

            var input = readLine()?.toIntOrNull()
            when (input) {
                in 1..6 -> {
                    selectMenu(input!!)
                }

                0 -> {
                    first()
                }

                else -> {
                    println("올바르지 않은 번호입니다. 다시 입력해주세요.\n")
                }
            }
        }
    }
}