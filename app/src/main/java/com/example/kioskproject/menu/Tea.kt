package com.example.kioskproject.menu

import com.example.kioskproject.Menu
import com.example.kioskproject.MenuItem
import com.example.kioskproject.detailCharge
import com.example.kioskproject.detailMenu
import com.example.kioskproject.totalMenu

class Tea : Common() {
    override fun displayInfo() {

        val teaList = mutableListOf(
            MenuItem(1, "페퍼민트(Hot)", 5500),
            MenuItem(2, "페퍼민트(Ice)", 5500),
            MenuItem(3, "캐모마일(Hot)", 5500),
            MenuItem(4, "캐모마일(Ice)", 6000),
            MenuItem(5, "녹차(Hot)", 5500),
            MenuItem(6, "녹차(Ice)", 6000)
        )
        while (true) {

            for ((a, b, c) in teaList) {
                println("$a. $b $c")
            }

            println("0. 뒤로가기")

            try {
                val num = readLine()?.toInt()

                if (num == 0) {
                    Menu().mainMenuList()
                    break
                } else {
                    detailMenu = teaList[num?.minus(1)!!].name
                    totalMenu.add(detailMenu)
                    detailCharge += teaList[num - 1].charge

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