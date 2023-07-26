package com.example.kioskproject.menu

import com.example.kioskproject.Menu
import com.example.kioskproject.MenuItem
import com.example.kioskproject.detailCharge
import com.example.kioskproject.detailMenu
import com.example.kioskproject.totalMenu

class NonCoffee : Common() {
    override fun displayInfo() {

        val nonCoffeeList = mutableListOf(
            MenuItem(1, "초코라떼(Hot)", 4000),
            MenuItem(2, "초코라떼(Ice)", 4500),
            MenuItem(3, "그린티라떼(Hot)", 4000),
            MenuItem(4, "그린티라떼(Ice)", 4500),
            MenuItem(5, "고구마라떼(Hot)", 4500),
            MenuItem(6, "고구마라떼(Ice)", 5000)
        )
        while (true) {

            for ((a, b, c) in nonCoffeeList) {
                println("$a. $b $c")
            }

            println("0. 뒤로가기")

            try {
                val num = readLine()?.toInt()

                if (num == 0) {
                    Menu().mainMenuList()
                    break
                } else {
                    detailMenu = nonCoffeeList[num?.minus(1)!!].name
                    totalMenu.add(detailMenu)
                    detailCharge += nonCoffeeList[num - 1].charge

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