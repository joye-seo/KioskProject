package com.example.kioskproject.menu

import com.example.kioskproject.Basket
import com.example.kioskproject.MenuItem
import com.example.kioskproject.detailMenu
import com.example.kioskproject.totalCharge

class NonCoffee : Common() {
    override fun displayInfo() {
        val list = listOf(
            MenuItem(1, "초코라떼(Hot)", 4000),
            MenuItem(2, "초코라떼(Ice)", 4500),
            MenuItem(3, "그린티라떼(Hot)", 4000),
            MenuItem(4, "그린티라떼(Ice)", 4500),
            MenuItem(5, "고구마라떼(Hot)", 4500),
            MenuItem(6, "고구마라떼(Ice)", 5000)
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