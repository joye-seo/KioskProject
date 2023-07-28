package com.example.kioskproject

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Timer
import java.util.TimerTask
import kotlin.system.exitProcess

//현재시간 가져옴 + 원하는 형태로 시간 출력 가능!!!!
val localTime = LocalDateTime.now()
val formatter = DateTimeFormatter.ofPattern("a HH시 mm분")
val chargeTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초")
val time = localTime.format(formatter)
val orderPeopleNum = 1..30

class ShoppingCart() {
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

                val cartNum = readLine()

                if (cartNum?.let { isNumericToX(it) } == true) {

                    if (cartNum == "1") {
                        UseCafe().mainMenu()
                        break
                    } else if (cartNum == "2") {
                        println("프로그램 종료")
                        exitProcess(0)
                    } else {
                        println(
                            "올바르지 않은 번호입니다. 다시 입력해주세요."
                                    + "\n----------------------------------\n"
                        )
                    }
                }
            }
        } else {
            //5초마다 내역 보여줌 + 주문 대기숫자 1~30으로 랜덤처리
            Timer().scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    println("현재 주문 대기수 : ${orderPeopleNum.random()}")
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

                }

            }, 0, 5000)

            val orderNum = readLine()

            while (true) {
                if (orderNum?.let { isNumericToX(it) } == true) {
                    when (orderNum) {
                        "1" -> {
                            if (time in "오후 11:00".."오후 11:59") {
                                println("현재시간은 $time 입니다.")
                                println("오후 11시 ~ 오후 11시 59분은 은행 점검시간이므로 이용하실 수 없습니다.")

                                exitProcess(0)
                            } else {
                                println("\n[결제하기]\n")
                                order()
                                break
                            }
                        }

                        "2" -> {
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
            println("결제시간 : ${localTime.format(chargeTimeFormatter)}")
        } else {
            println("${totalCharge - pocketMoney}원이 부족해 음료를 구매할 수 없습니다.")
        }
        exitProcess(0)
    }
}