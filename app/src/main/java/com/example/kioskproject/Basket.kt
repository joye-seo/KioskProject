package com.example.kioskproject

class Basket() {
    fun payment() {
//        totalMenu
        println(
            "----------------------------------\n" +
                    "주문 내역 입니다.\n" +
                    "$method\n"

        )
        for (i in totalMenu) {
            println(i)
        }
        println("\n합계는 $detailCharge 입니다.\n")
        println("현재 지갑에 있는 돈은 $pocketMoney 입니다.")
        if (pocketMoney>= detailCharge){
            println("현재 남은 돈은 ${ pocketMoney - detailCharge }원 입니다.")
        }else{
            println("${ detailCharge - pocketMoney }원이 부족해 음료를 구매할 수 없습니다.")
        }
    }
}