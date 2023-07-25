package com.example.kioskproject

class Basket() {
    fun payment() {
        println(
            "----------------------------------\n" +
                    "주문 내역 입니다.\n" +
                    "$method\n" +
                    "$detailMenu\n" +
                    "$totalCharge"
        )
    }
}