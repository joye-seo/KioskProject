package com.example.kioskproject

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.system.exitProcess

class ShoppingCart() {
    //현재시간 가져옴 + 원하는 형태로 시간 출력 가능!!!!
    val localTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("a HH시 mm분")
    val time = localTime.format(formatter)

    fun cart() {
//        totalMenu
        if (totalMenu.size == 0) {
            println(
                "장바구니에 담긴 물건이 없습니다.\n"
                        + "다시 주문하시겠습니까?\n"
            )

            while (true) {
                println(
                    "1. 주문하기\n"
                            + "2. 프로그램 종료"
                )

                val cartNum = readLine()?.toInt()

                if (cartNum == 1) {
                    UseCafe().mainMenu()
                    break
                } else if (cartNum == 2) {
                    println("프로그램 종료")
                    exitProcess(0)
                } else {
                    println(
                        "올바르지 않은 번호입니다. 다시 입력해주세요."
                                + "\n----------------------------------\n"
                    )
                }
            }
        } else {
            println(
                "----------------------------------\n" +
                        "이용방법 : $method\n" +
                        "[ 장 바 구 니 ]"
            )

            for (i in totalMenu) {
                println(i)
            }

            println("\n합계 $totalCharge 원\n")

            println(
                "1. 결제하기\n"
                        + "2. 메뉴추가\n"
            )

            val orderNum = readLine()?.toInt()

            while (true) {
                when (orderNum) {
                    1 -> {
                        if (time in "오후 11:00".."오후 11:59") {
                            println("현재시간은 $time 입니다.")
                            println("오후 11시 ~ 오후 11시 59분은 은행 점검시간이므로 이용하실 수 없습니다.")

                            exitProcess(0)
                        } else {
                            println("[결제하기]\n")
                            order()
                            break
                        }
                    }

                    2 -> {
                        UseCafe().mainMenu()
                        break
                    }

                    else -> println(
                        "올바르지 않은 번호입니다. 다시 입력해주세요."
                                + "\n----------------------------------\n"
                    )
                }
            }
        }
    }
}

fun order() {

    println("현재 지갑에 있는 돈은 $pocketMoney 원 입니다.")
    if (pocketMoney >= totalCharge) {
        println("현재 남은 돈은 ${pocketMoney - totalCharge}원 입니다.")
    } else {
        println("${totalCharge - pocketMoney}원이 부족해 음료를 구매할 수 없습니다.")
    }

    exitProcess(0)

}