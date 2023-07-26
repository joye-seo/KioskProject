package com.example.kioskproject

import com.example.kioskproject.data.Item
import com.example.kioskproject.data.Menu

class UseCafe() {
    fun mainMenu() {


        val menuList = mutableListOf(
            Menu("Coffee"),
            Menu("Non-Coffee"),
            Menu("Ade"),
            Menu("Smoothie"),
            Menu("Tea"),
            Menu("Dessert"),
            Menu("장바구니"),
            Menu("프로그램 종료"),
        )
        println("\n아래 메뉴판을 보시고 메뉴를 골라 입력해주세요")
        menuList.forEachIndexed { index, menu ->
            println("${index + 1} ${menu.name}")
        }

        val read = readLine()!!.toInt()
        when (read) {
            1 -> {
                val coffeeList = mutableListOf(
                    Item("에스프레소", 3000),
                    Item("아메리카노(Hot)", 3000),
                    Item("아메리카노(Ice)", 3500),
                    Item("카페라떼(Hot)", 4000),
                    Item("카페라떼(Ice)", 4500),
                    Item("카푸치노(Hot)", 4000),
                    Item("카푸치노(Ice)", 4500),
                )
                while (true) {
                    coffeeList.forEachIndexed { index, item ->
                        println("${index + 1} ${item.name}, ${item.charge}원")
                    }
                    val back = coffeeList.size + 1
                    println("${back}. 뒤로가기")

                    try {
                        val num = readLine()?.toInt()

                        if (num == back) {
                            mainMenu()
                            break
                        } else {
                            detailMenu = coffeeList[num?.minus(1)!!].name
                            totalMenu.add(detailMenu)
                            totalCharge += coffeeList[num.minus(1)].charge

                            println("\n$detailMenu 를 장바구니에 넣었습니다\n")
                        }

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

            2 -> {
                val nonCoffeeList = mutableListOf(
                    Item("초코라떼(Hot)", 4000),
                    Item("초코라떼(Ice)", 4500),
                    Item("그린티라떼(Hot)", 4000),
                    Item("그린티라떼(Ice)", 4500),
                    Item("고구마라떼(Hot)", 4500),
                    Item("고구마라떼(Ice)", 5000)
                )
                while (true) {
                    nonCoffeeList.forEachIndexed { index, item ->
                        println("${index + 1} ${item.name}, ${item.charge}원")
                    }
                    val back = nonCoffeeList.size + 1
                    println("${back}. 뒤로가기")

                    try {
                        val num = readLine()?.toInt()

                        if (num == back) {
                            mainMenu()
                            break
                        } else {
                            detailMenu = nonCoffeeList[num?.minus(1)!!].name
                            totalMenu.add(detailMenu)
                            totalCharge += nonCoffeeList[num.minus(1)].charge

                            println("\n$detailMenu 를 장바구니에 넣었습니다\n")
                        }

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

            3 -> {
                val adeList = mutableListOf(
                    Item("레몬에이드", 5000),
                    Item("자몽에이드", 5000),
                    Item("딸기에이드", 5000),
                    Item("블루베리에이드", 5500)
                )
                while (true) {
                    adeList.forEachIndexed { index, item ->
                        println("${index + 1} ${item.name}, ${item.charge}원")
                    }
                    val back = adeList.size + 1
                    println("${back}. 뒤로가기")

                    try {
                        val num = readLine()?.toInt()

                        if (num == back) {
                            mainMenu()
                            break
                        } else {
                            detailMenu = adeList[num?.minus(1)!!].name
                            totalMenu.add(detailMenu)
                            totalCharge += adeList[num.minus(1)].charge

                            println("\n$detailMenu 를 장바구니에 넣었습니다\n")
                        }

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

            4 -> {
                val smoothieList = mutableListOf(
                    Item("요거트스무디", 5500),
                    Item("딸기스무디", 5500),
                    Item("망고스무디", 5500),
                    Item("블루베리스무디", 6000)
                )
                while (true) {
                    smoothieList.forEachIndexed { index, item ->
                        println("${index + 1} ${item.name}, ${item.charge}원")
                    }
                    val back = smoothieList.size + 1
                    println("${back}. 뒤로가기")

                    try {
                        val num = readLine()?.toInt()

                        if (num == back) {
                            mainMenu()
                            break
                        } else {
                            detailMenu = smoothieList[num?.minus(1)!!].name
                            totalMenu.add(detailMenu)
                            totalCharge += smoothieList[num.minus(1)].charge

                            println("\n$detailMenu 를 장바구니에 넣었습니다\n")
                        }

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

            5 -> {
                val teaList = mutableListOf(
                    Item("페퍼민트(Hot)", 5500),
                    Item("페퍼민트(Ice)", 5500),
                    Item("캐모마일(Hot)", 5500),
                    Item("캐모마일(Ice)", 6000),
                    Item("녹차(Hot)", 5500),
                    Item("녹차(Ice)", 6000)
                )
                while (true) {
                    teaList.forEachIndexed { index, item ->
                        println("${index + 1} ${item.name}, ${item.charge}원")
                    }
                    val back = teaList.size + 1
                    println("${back}. 뒤로가기")
                    try {
                        val num = readLine()?.toInt()

                        if (num == back) {
                            mainMenu()
                            break
                        } else {
                            detailMenu = teaList[num?.minus(1)!!].name
                            totalMenu.add(detailMenu)
                            totalCharge += teaList[num.minus(1)].charge

                            println("\n$detailMenu 를 장바구니에 넣었습니다\n")
                        }

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

            6 -> {
                val dessertList = mutableListOf(
                    Item("허니브레드", 8000),
                    Item("치즈케이크", 8500),
                    Item("딸기케이크", 8500),
                    Item("당근케이크", 8000)
                )
                while (true) {
                    dessertList.forEachIndexed { index, item ->
                        println("${index + 1} ${item.name}, ${item.charge}원")
                    }
                    val back = dessertList.size + 1
                    println("${back}. 뒤로가기")

                    try {
                        val num = readLine()?.toInt()

                        if (num == back) {
                            mainMenu()
                            break
                        } else {
                            detailMenu = dessertList[num?.minus(1)!!].name
                            totalMenu.add(detailMenu)
                            totalCharge += dessertList[num.minus(1)].charge

                            println("\n$detailMenu 를 장바구니에 넣었습니다\n")
                        }

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
        Cart().payment()
    }

}
