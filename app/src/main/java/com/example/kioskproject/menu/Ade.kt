package com.example.kioskproject.menu

import com.example.kioskproject.Basket
import com.example.kioskproject.MenuItem
import com.example.kioskproject.detailMenu
import com.example.kioskproject.totalCharge

class Ade : Common() {
    override fun displayInfo() {
        val list = listOf(
            MenuItem(1, "레몬에이드", 5000),
            MenuItem(2, "레몬에이드", 5000),
            MenuItem(3, "딸기에이드", 5000),
            MenuItem(4, "블루베리에이드", 5500)
        )
        while (true) {

            for ((a, b, c) in list) {
                println("$a. $b $c")
            }

            try {
                val num = readLine()?.toInt()
                detailMenu = list[num?.minus(1)!!].name
                totalCharge = list[num - 1].charge
                Basket().payment()
                break

            } catch (e: java.lang.NumberFormatException) {
                println(
                    "메뉴 주문은 숫자만 입력할 수 있습니다.\n"
                            + "----------------------------------\n"
                )
            } catch (e: ArrayIndexOutOfBoundsException) {
                println(
                    "올바르지 않은 번호입니다. 다시 입력해주세요.\n"
                            + "----------------------------------\n"
                )
            }
        }
    }

}