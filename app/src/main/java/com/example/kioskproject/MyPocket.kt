package com.example.kioskproject

class MyPocket {
    fun money() {
        while (true) {
            try {
                println("현재 소지하고있는 금액을 입력해주세요")
                pocketMoney = readLine()?.toInt() ?: continue
                break

            } catch (e: java.lang.NumberFormatException) {
                println(
                    "소지하고 있는 금액은 숫자만 입력할 수 있습니다.\n"
                            + "----------------------------------\n"
                )
            }
        }

    }
}