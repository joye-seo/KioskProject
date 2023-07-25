package com.example.kioskproject.menu

import com.example.kioskproject.Basket
import com.example.kioskproject.MenuItem
import com.example.kioskproject.detailMenu
import com.example.kioskproject.totalCharge

class Coffee : Common() {
    override fun displayInfo() {
        val list = listOf(
            MenuItem(1, "에스프레소", 3000),
            MenuItem(2, "아메리카노(Hot)", 3000),
            MenuItem(3, "아메리카노(Ice)", 3500),
            MenuItem(4, "카페라떼(Hot)", 4000),
            MenuItem(5, "카페라떼(Ice)", 4500),
            MenuItem(6, "카푸치노(Hot)", 4000),
            MenuItem(7, "카푸치노(Ice)", 4500)
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