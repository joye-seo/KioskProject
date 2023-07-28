package com.example.kioskproject

class MyPocket {
    fun money() {
        while (true) {

            println("현재 소지하고있는 금액을 입력해주세요")

            val pocketMoney = readLine()
            if (pocketMoney?.let { isNumericToX(it) } == true) {
                break
            }
        }

    }
}