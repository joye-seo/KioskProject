package com.example.kioskproject.menu

import com.example.kioskproject.Menu
import com.example.kioskproject.MenuItem
import com.example.kioskproject.detailCharge
import com.example.kioskproject.detailMenu
import com.example.kioskproject.totalMenu

class Smoothie : Common() {
    override fun displayInfo() {
        val list = listOf(
            MenuItem(1, "요거트스무디", 5500),
            MenuItem(2, "딸기스무디", 5500),
            MenuItem(3, "망고스무디", 5500),
            MenuItem(4, "블루베리스무디", 6000)
        )
        while (true) {

            for ((a, b, c) in list) {
                println("$a. $b $c")
            }

            println("5. 뒤로가기")

            try {
                val num = readLine()?.toInt()

                if (num == 5) {
                    Menu().mainMenuList()
                    break
                } else {
                    detailMenu = list[num?.minus(1)!!].name
                    totalMenu.add(detailMenu)
                    detailCharge += list[num - 1].charge

                    println("\n$detailMenu 를 장바구니에 넣었습니다\n")
                }

//                Basket().payment()
//                break

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