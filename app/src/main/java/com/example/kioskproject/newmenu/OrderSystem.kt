package com.example.kioskproject.newmenu

open class OrderSystem() {
    val menuCategory = Menu()
    val cartItem = mutableListOf<MenuItem>()

    // 메뉴 선택 화면 출력
    fun selectMenu(menuNumber:Int) {
        while (true) {
            val menuSelection = menuCategory.sub(menuNumber)

            menuSelection?.forEach { (number, description, price : Int) ->
                if (number != 0) {
                    println("$number. $description | $price")
                }
            }
            println("0. 뒤로가기")
            println("\n주문하실 메뉴를 선택하세요 (여러가지일 경우 띄어쓰기로 구분)")

            var selectedItems = readLine()?.split(" ") ?: emptyList()
            val selectedItemChargeList = mutableListOf<Int>()
            val selectname = mutableListOf<String>()

            for (item in selectedItems) {
                val itemNum = item.toIntOrNull()
                if (itemNum == 0) {
                    return
                } else if (menuSelection?.any { it.id == itemNum } == true) {
                    val menuItem = menuSelection.find { it.id == itemNum }
                    if (menuItem != null) {
                        cartItem.add(menuItem)
                        selectname.add(menuItem.name)
                    }
                } else {
                    println("${item} 번호는 잘못 입력하셨습니다. 다시 입력해주세요.\n")
                    selectMenu(menuNumber)
                    return
                }
            }
            println("\n장바구니 내용")
            for (item in cartItem) {
                println("${item.name} ${item.price}")
            }
            println()
            while(true)
            {
                println("----------------------------------------")
                println("1. 추가 주문")
                println("2. 결 제")
                println("3. 결제 취소")
                println("----------------------------------------")

                val totalPrice = cartItem.sumBy { it.price }
                val selectedName = cartItem.map { it.name }
                val selectedMutableList = selectedName.joinToString(", ")
                val choice = readLine()?.toIntOrNull()
                when (choice) {
                    1 -> {
                        return
                    }
                    2 -> {
                        println("현재 가지고 있는 금액을 입력하세요.")
                        var charge = readLine()?.toIntOrNull()
                        if(charge != null)
                        {
                            print("결제를 진행하시겠습니까? (Y/N) : ")
                            var pay = readLine().toString()
                            if(pay == "Y" || pay == "y")
                            {
                                println("\n------------ 영 수 증 -----------------")
                                println("$selectedMutableList")
                                println("결 제 금 액 : $totalPrice")
                                println("----------------------------------------\n")
                                if(charge >= totalPrice)
                                {
                                    println("결제 완료! 감사합니다.")
                                    System.exit(0)
                                }
                            }
                            else if(pay == "N" || pay == "n")
                            {
                                println("결제를 취소합니다.")
                                println("메인 화면으로 이동합니다.")
                                println("----------------------------------------\n")
                            }
                            else
                            {
                                println("??? 잘못된 입력 ????\nY와 N 중에 입력해주세요.")
                            }
                        }
                    }
                    3 -> {
                        println("----------------------------------------")
                        println("주 문 취 소")
                        println("----------------------------------------\n")
                        cartItem.clear()
                        Order().mainmenu()
                        break
                    }
                    else -> {
                        println("잘못 입력하셨습니다. 다시 입력해주세요.")
                        continue
                    }
                }
            }
        }
    }
}