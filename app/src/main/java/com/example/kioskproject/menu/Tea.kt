package com.example.kioskproject.menu

import com.example.kioskproject.Basket
import com.example.kioskproject.MenuItem
import com.example.kioskproject.detailMenu
import com.example.kioskproject.totalCharge

class Tea : Common() {
    override fun displayInfo() {
        val list = listOf(
            MenuItem(1, "페퍼민트(Hot)", 5500),
            MenuItem(2, "페퍼민트(Ice)", 5500),
            MenuItem(3, "캐모마일(Hot)", 5500),
            MenuItem(4, "캐모마일(Ice)", 6000),
            MenuItem(5, "녹차(Hot)", 5500),
            MenuItem(6, "녹차(Ice)", 6000)
        )
        for ((a, b, c) in list) {
            println("$a. $b $c")
        }
        try {
            while (true) {
                val num = readLine()?.toInt()
                detailMenu = list[num?.minus(1)!!].name //코드 수정해보기
                totalCharge = list[num - 1].charge //코드 수정해보기
                break
            }

        } catch (e: java.lang.NumberFormatException) {
            println(
                "메뉴 주문은 숫자만 입력할 수 있습니다.\n"
                        + "----------------------------------\n"
            )
        }
        Basket().payment()
    }

}