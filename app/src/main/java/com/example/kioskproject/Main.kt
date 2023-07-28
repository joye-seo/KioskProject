package com.example.kioskproject

import com.example.kioskproject.data.Menu
import kotlin.system.exitProcess

fun isNumericToX(toCheck: String): Boolean {
    return toCheck.toIntOrNull() != null
}

fun main() {
    MyPocket().money()
    println("\n안녕하세요? 투썸플레이스입니다.")
    Main().startOrder()

}

var method: String = ""
var detailMenu: String = ""
var totalMenu: MutableList<String> = mutableListOf()
var totalCharge: Int = 0
var pocketMoney = 0

class Main {
    fun startOrder() {

        while (true) {
            println(
                "주문을 하시려면 1번을 눌러주세요.\n" +
                        "1 주문하기\n" +
                        "2 프로그램 종료."
            )

            val num = readLine()

            if (num?.let { isNumericToX(it) } == true) {
                when (num.toInt()) {
                    1 -> {
                        while (true) {

                            println("\n매장 이용 방법을 선택해주세요")

                            val useMethod = mutableListOf(
                                Menu("매장식사"),
                                Menu("포장하기"),
                                Menu("프로그램 종료"),
                            )
                            useMethod.forEachIndexed { index, menu ->
                                println("${index + 1} ${menu.name}")
                            }

                            val useMethodNum = readLine()

                            if (useMethodNum?.let { isNumericToX(it) } == true) {

                                when (useMethodNum.toInt()) {
                                    1, 2 -> {
                                        method = if (useMethodNum.toInt() == 1) {
                                            "매장식사"
                                        } else {
                                            "포장하기"
                                        }
                                        UseCafe().mainMenu()
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
                            }
                        }
                    }

                    2 -> {
                        println("프로그램 종료")
                        exitProcess(0)
                    }

                    else -> println(
                        "올바르지 않은 번호입니다. 다시 입력해주세요.\n"
                                + "----------------------------------\n"
                    )
                }
            }
        }
    }
}



